package com.bookMyShowAPI.BMS.converter;


import com.bookMyShowAPI.BMS.Model.TicketEntity;
import com.bookMyShowAPI.BMS.Model.UserEntity;
import com.bookMyShowAPI.BMS.dto.EntryRequest.UserEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.UserResponseDto;
import com.bookMyShowAPI.BMS.dto.TicketDto;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {


    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){

        //.builder() is a method

        //I need to create the User
        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobNo()).build();


        //Second method for creating the object ??
        //Using the new keyword

    }

    public static UserResponseDto convertEntityToDto(UserEntity user){
        List<TicketEntity> ticketEntities = user.getTicketEntities();

        List<TicketDto> ticketDtos = new ArrayList<>();

        for(TicketEntity ticketEntity : ticketEntities){
            TicketDto ticketDto = TicketConvertor.convertEntityToDto(ticketEntity);
            ticketDtos.add(ticketDto);
        }
        return UserResponseDto.builder().id(user.getId()).name(user.getName())
                .mobNo(user.getMobile())
                .tickets(ticketDtos)
                .build();

    }



}
