package com.bookMyShowAPI.BMS.converter;


import com.bookMyShowAPI.BMS.Model.MovieEntity;
import com.bookMyShowAPI.BMS.dto.EntryRequest.MovieEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.MovieNameAndIdObject;
import com.bookMyShowAPI.BMS.dto.ResponseDto.MovieResponseDto;

public class MovieConverter {


    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){

        return MovieEntity.builder().name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate()).build();
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity){

        return MovieResponseDto.builder().id(movieEntity.getId()).releaseDate(movieEntity.getReleaseDate())
                .name(movieEntity.getName()).build();
    }

    public static MovieNameAndIdObject convertEntityToThisObject(MovieEntity movieEntity){
        return MovieNameAndIdObject.builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName())
                .build();
    }



}
