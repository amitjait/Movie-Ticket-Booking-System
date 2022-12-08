package com.bookMyShowAPI.BMS.service;


import com.bookMyShowAPI.BMS.dto.BookTicketRequestDto;
import com.bookMyShowAPI.BMS.dto.TicketDto;

public interface TicketService {


        TicketDto getTicket(int id); //H.W (Hint is same as you do in GetMovie)

        TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto);


}
