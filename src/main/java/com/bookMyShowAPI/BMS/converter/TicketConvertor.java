package com.bookMyShowAPI.BMS.converter;

import com.bookMyShowAPI.BMS.Model.TicketEntity;
import com.bookMyShowAPI.BMS.dto.TicketDto;

public class TicketConvertor {

    public static TicketDto convertEntityToDto(TicketEntity ticketEntity){

        return TicketDto.builder().id((int) ticketEntity.getId()).amount(ticketEntity.getAmount())
                .allotted_seats(ticketEntity.getAllottedSeats())
                        .build();

    }
}
