package com.bookMyShowAPI.BMS.service;


import com.bookMyShowAPI.BMS.dto.EntryRequest.MovieEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.MovieNameAndIdObject;
import com.bookMyShowAPI.BMS.dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    //Add movie
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);


    //get movie
    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);

}
