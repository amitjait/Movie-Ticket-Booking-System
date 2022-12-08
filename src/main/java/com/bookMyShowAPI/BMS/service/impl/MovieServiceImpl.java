package com.bookMyShowAPI.BMS.service.impl;


import com.bookMyShowAPI.BMS.Model.MovieEntity;
import com.bookMyShowAPI.BMS.Model.ShowEntity;
import com.bookMyShowAPI.BMS.Repository.MovieRepository;
import com.bookMyShowAPI.BMS.converter.MovieConverter;
import com.bookMyShowAPI.BMS.dto.EntryRequest.MovieEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.MovieNameAndIdObject;
import com.bookMyShowAPI.BMS.dto.ResponseDto.MovieResponseDto;
import com.bookMyShowAPI.BMS.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowServiceImpl showService;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {

        //if the movie is already created then we can throw an exception....movie already exists.

        MovieResponseDto movieResponseDto = null;

        if(movieRepository.count() > 0) {
            List<MovieEntity> list = movieRepository.findAll();
            // if movie exits already then throw an error and search by name
            for (MovieEntity movieEntity : list) {
                if (movieEntity.getName().equals(movieEntryDto.getName())) {
                    movieResponseDto.setName("This movie is already Existing");
                    return movieResponseDto;
                }
            }
        }

        log.info("Adding the movie",movieEntryDto);


        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);
        movieEntity = movieRepository.save(movieEntity);

         movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);

        return movieResponseDto; //It can be a response type of the movie

    }

    @Override
    public MovieResponseDto getMovie(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;

    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieNameAndIdObject movieNameAndIdObject = MovieConverter.convertEntityToThisObject(movieEntity);
        return movieNameAndIdObject;
    }

    public void deleteMovieById(int id){
        MovieEntity movieEntity = movieRepository.findById(id).get();

        List<ShowEntity> showEntities = movieEntity.getShows();

        for(ShowEntity showEntity : showEntities){
            showService.deleteShowById(showEntity.getId());
        }

        movieRepository.delete(movieEntity);

    }

}
