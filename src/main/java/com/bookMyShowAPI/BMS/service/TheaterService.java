package com.bookMyShowAPI.BMS.service;


import com.bookMyShowAPI.BMS.dto.EntryRequest.TheaterEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.TheaterResponseDto;

public interface TheaterService {


    TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);

    TheaterResponseDto getTheater(int id);

}
