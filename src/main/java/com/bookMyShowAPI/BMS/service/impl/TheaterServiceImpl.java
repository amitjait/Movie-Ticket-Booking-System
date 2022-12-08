package com.bookMyShowAPI.BMS.service.impl;

import com.bookMyShowAPI.BMS.Model.TheaterEntity;
import com.bookMyShowAPI.BMS.Model.TheaterSeatsEntity;
import com.bookMyShowAPI.BMS.Repository.TheaterRepository;
import com.bookMyShowAPI.BMS.Repository.TheaterSeatsRepository;
import com.bookMyShowAPI.BMS.converter.TheaterConverter;
import com.bookMyShowAPI.BMS.dto.EntryRequest.TheaterEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.TheaterResponseDto;
import com.bookMyShowAPI.BMS.enums.SeatType;
import com.bookMyShowAPI.BMS.enums.TheaterType;
import com.bookMyShowAPI.BMS.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {

        TheaterEntity theaterEntity = TheaterConverter.convertDtoToEntity(theaterEntryDto);


        //create the Seats
        List<TheaterSeatsEntity> seats = createTheaterSeats();

        //I need to set the theaterId for all these seats
        theaterEntity.setSeats(seats);

        theaterEntity.setShows(null);

        for(TheaterSeatsEntity theaterSeatsEntity:seats){
            theaterSeatsEntity.setTheater(theaterEntity);
        }

        theaterEntity.setTheaterType(TheaterType.SINGLE);

        theaterEntity = theaterRepository.save(theaterEntity);

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterResponseDto;

    }

    List<TheaterSeatsEntity> createTheaterSeats(){


        List<TheaterSeatsEntity> seats = new ArrayList<>();

        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("2A",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E",100,SeatType.PREMIUM));


        theaterSeatsRepository.saveAll(seats);

        return seats;
        //Add in this TheaterSeatEntity type

    }

    TheaterSeatsEntity getTheaterSeat(String seatName, int rate, SeatType seatType){

        return TheaterSeatsEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }

    //Separate function will be create...


    @Override
    public TheaterResponseDto getTheater(int id) {

        TheaterEntity theaterEntity = theaterRepository.findById(id).get();

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterResponseDto;
    }
}
