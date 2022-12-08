package com.bookMyShowAPI.BMS.service.impl;

import com.bookMyShowAPI.BMS.Model.*;
import com.bookMyShowAPI.BMS.Repository.MovieRepository;
import com.bookMyShowAPI.BMS.Repository.ShowRepository;
import com.bookMyShowAPI.BMS.Repository.ShowSeatsRepository;
import com.bookMyShowAPI.BMS.Repository.TheaterRepository;
import com.bookMyShowAPI.BMS.converter.ShowConvertor;
import com.bookMyShowAPI.BMS.dto.EntryRequest.ShowEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.ShowResponseDto;
import com.bookMyShowAPI.BMS.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showDto) {


        //We have made the partial Show Entity Object..

        //Goal : Set the Movie and the Theater Entities and not the Dto

        ShowEntity showEntity = ShowConvertor.convertDtoToEntity(showDto);

        showEntity.setCreatedAt(new Date());
        showEntity.setUpdatedAt(new Date());

        //MovieEntity

        MovieEntity movieEntity = movieRepository.findById(showDto.getMovieResponseDto().getId()).get();

        TheaterEntity theaterEntity = theaterRepository.findById(showDto.getTheaterResponseDto().getId()).get();


        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theaterEntity);


        showEntity = showRepository.save(showEntity);
        //We need to pass the list of the theater seats
        generateShowEntitySeats(theaterEntity.getSeats(),showEntity);

        ShowResponseDto showResponseDto = ShowConvertor.convertEntityToDto(showEntity, showDto);


        return showResponseDto;

    }

    @Override
    public ShowResponseDto getShow(int id) {

        ShowEntity showEntity = null;

        if(showRepository.findById(id).isPresent()){
            showEntity = showRepository.findById(id).get();
        }

//                convert ShowEntity to ShowResponseDto
        if(showEntity == null){
            return null;
        }

        ShowResponseDto showResponseDto = ShowConvertor.convertEntityToDto(showEntity);
        return showResponseDto;
    }

    public void generateShowEntitySeats(List<TheaterSeatsEntity> theaterSeatsEntityList, ShowEntity showEntity){

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();

        //For all the seats in the theater


        for(TheaterSeatsEntity tse : theaterSeatsEntityList){

            //I need to create a ShowSeats Entity save it.
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber())
                    .seatType(tse.getSeatType())
                    .rate(tse.getRate())
                    .build();

            showSeatsEntityList.add(showSeatsEntity);
        }

        //We need to set the show Entity for each of the ShowSeat....
        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){

            showSeatsEntity.setShow(showEntity);
        }

        showEntity.setSeats(showSeatsEntityList);

        showSeatsRepository.saveAll(showSeatsEntityList);

    }

    public void deleteShowById(int id){
        ShowEntity showEntity = showRepository.findById(id).get();

        int showId = showEntity.getId();

        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getSeats();

        showSeatsRepository.deleteAll(showSeatsEntityList);

        showRepository.delete(showEntity);
    }

}
