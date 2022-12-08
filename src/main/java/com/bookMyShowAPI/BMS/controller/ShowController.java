package com.bookMyShowAPI.BMS.controller;

import com.bookMyShowAPI.BMS.dto.EntryRequest.ShowEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.ShowResponseDto;
import com.bookMyShowAPI.BMS.service.impl.ShowServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
@Slf4j
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody() ShowEntryDto showEntryDto){
        ShowResponseDto showResponseDto = showService.addShow(showEntryDto);

        return showResponseDto;
    }
    @GetMapping("/get/{id}")
    public ShowResponseDto getShow(@PathVariable("id") int id){
        ShowResponseDto showResponseDto = showService.getShow(id);

        return showResponseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteShowById(int id){

        try {
            showService.deleteShowById(id);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Deleted Show Successfully", HttpStatus.OK);
    }

}
