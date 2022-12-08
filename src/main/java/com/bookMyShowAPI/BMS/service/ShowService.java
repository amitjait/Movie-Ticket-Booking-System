package com.bookMyShowAPI.BMS.service;


import com.bookMyShowAPI.BMS.dto.EntryRequest.ShowEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.ShowResponseDto;

public interface ShowService {

    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    ShowResponseDto getShow(int id);
    //Get show
    //Complete
}
