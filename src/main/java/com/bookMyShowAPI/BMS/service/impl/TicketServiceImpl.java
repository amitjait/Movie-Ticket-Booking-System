package com.bookMyShowAPI.BMS.service.impl;

import com.bookMyShowAPI.BMS.Model.ShowEntity;
import com.bookMyShowAPI.BMS.Model.ShowSeatsEntity;
import com.bookMyShowAPI.BMS.Model.TicketEntity;
import com.bookMyShowAPI.BMS.Model.UserEntity;
import com.bookMyShowAPI.BMS.Repository.ShowRepository;
import com.bookMyShowAPI.BMS.Repository.TicketRepository;
import com.bookMyShowAPI.BMS.Repository.UserRepository;
import com.bookMyShowAPI.BMS.converter.TicketConvertor;
import com.bookMyShowAPI.BMS.dto.BookTicketRequestDto;
import com.bookMyShowAPI.BMS.dto.TicketDto;
import com.bookMyShowAPI.BMS.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketDto getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();

        TicketDto ticketDto = TicketConvertor.convertEntityToDto(ticketEntity);

        return ticketDto;
    }

    @Override
    public TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {


        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getUserId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();
        Set<String> requestSeats = bookTicketRequestDto.getRequestedSeats();
        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getSeats();
//        log.info("getting seats", showSeatsEntityList);


        //Option 1
        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList
                .stream()
                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&!seat.isBooked()&&
                        requestSeats.contains(seat.getSeatNumber()))
                .collect(Collectors.toList());


        //Option 2
//        List<ShowSeatsEntity> bookedSeats1 = new ArrayList<>();
//
//        for(ShowSeatsEntity seat :showSeatsEntityList){
//
//            if(!seat.isBooked()&&seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&requestSeats.contains(seat.getSeatNumber())){
//                bookedSeats1.add(seat);
//            }
//        }

        if(bookedSeats.size()!=requestSeats.size()){
            //All the seats were not available
            throw new Error("All Seats not available");
        }

        //Step 2

        TicketEntity ticketEntity = TicketEntity.builder()
                                    .user(userEntity)
                                    .show(showEntity)
                                    .seats(bookedSeats)
                                    .build();



        //Step 3 :

        double amount = 0;

        for(ShowSeatsEntity showSeatsEntity: bookedSeats){

            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount = amount + showSeatsEntity.getRate();
        }

        ticketEntity.setBookedAt(new Date());

        String bookedSeatsStr = convertListOfSeatsEntityToString(bookedSeats);

//        for(ShowSeatsEntity seats : bookedSeats){
//            bookedSeatsStr+=seats.getSeatNumber()+" ";
//        }

        ticketEntity.setAllottedSeats(bookedSeatsStr);

        ticketEntity.setAmount(amount);


        //Connect in thw Show and the user

        showEntity.getTickets().add(ticketEntity);


        //Add the ticket in the tickets list of the user Entity
        userEntity.getTicketEntities().add(ticketEntity);


        ticketEntity = ticketRepository.save(ticketEntity);

        return TicketConvertor.convertEntityToDto(ticketEntity);
    }

    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){
        String str = "";

        for(ShowSeatsEntity showSeatsEntity : bookedSeats){
            str += showSeatsEntity.getSeatNumber() + " ";
        }

        return str;
    }
}
