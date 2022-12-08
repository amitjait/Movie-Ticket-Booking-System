package com.bookMyShowAPI.BMS.dto;

import com.bookMyShowAPI.BMS.dto.ResponseDto.ShowResponseDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

    int id;

    String allotted_seats;

    double amount;

    ShowResponseDto shows;

//    @NotNull
    UserResponseDto user; //Mandatory for me to fill this userDto Value
}
