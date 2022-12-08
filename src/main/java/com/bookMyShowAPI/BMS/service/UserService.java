package com.bookMyShowAPI.BMS.service;


import com.bookMyShowAPI.BMS.dto.EntryRequest.UserEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.UserResponseDto;

public interface UserService { //Designing part

    void addUser(UserEntryDto userEntryDto);

    UserResponseDto getUser(int id);


}
