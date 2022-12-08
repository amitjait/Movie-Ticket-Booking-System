package com.bookMyShowAPI.BMS.controller;


import com.bookMyShowAPI.BMS.dto.EntryRequest.TheaterEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.TheaterResponseDto;
import com.bookMyShowAPI.BMS.service.impl.TheaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterServiceImpl theaterService;

    @PostMapping("/add")
    public TheaterResponseDto addTheater(@RequestBody() TheaterEntryDto theaterEntryDto){
        TheaterResponseDto theaterResponseDto = theaterService.addTheater(theaterEntryDto);

        return theaterResponseDto;
    }

    @GetMapping("/get/{id}")
    public TheaterResponseDto getTheaterBYId(@PathVariable("id") int id){
        TheaterResponseDto theaterResponseDto = theaterService.getTheater(id);

        return theaterResponseDto;
    }
}
