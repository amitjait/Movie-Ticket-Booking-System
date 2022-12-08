package com.bookMyShowAPI.BMS.converter;


import com.bookMyShowAPI.BMS.Model.TheaterEntity;
import com.bookMyShowAPI.BMS.dto.EntryRequest.TheaterEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.TheaterResponseDto;

public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        return TheaterEntity.builder().address(theaterEntryDto.getAddress())
                .city(theaterEntryDto.getCity()).name(theaterEntryDto.getName()).build();

    }

    public static TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity){

        return TheaterResponseDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .city(theaterEntity.getCity()).address(theaterEntity.getAddress()).build();
    }
}
