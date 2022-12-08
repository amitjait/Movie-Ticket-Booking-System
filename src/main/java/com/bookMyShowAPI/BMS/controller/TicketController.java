package com.bookMyShowAPI.BMS.controller;


import com.bookMyShowAPI.BMS.dto.BookTicketRequestDto;
import com.bookMyShowAPI.BMS.dto.TicketDto;
import com.bookMyShowAPI.BMS.service.impl.TicketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/add")
    public TicketDto addTicket(@RequestBody() BookTicketRequestDto bookTicketRequestDto){
        TicketDto ticketDto = ticketService.bookTicket(bookTicketRequestDto);

        return ticketDto;
    }

    @GetMapping("/get/{id}")
    public TicketDto getTicket(@PathVariable() Integer id){
        TicketDto ticketDto = ticketService.getTicket(id);
        return ticketDto;
    }
}
