package com.bookMyShowAPI.BMS.controller;

import com.bookMyShowAPI.BMS.dto.EntryRequest.MovieEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.MovieNameAndIdObject;
import com.bookMyShowAPI.BMS.dto.ResponseDto.MovieResponseDto;
import com.bookMyShowAPI.BMS.service.impl.MovieServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public MovieResponseDto addMovie(@RequestBody() MovieEntryDto movieEntryDto){
        MovieResponseDto movieResponseDto = movieService.addMovie(movieEntryDto);

        return movieResponseDto;
    }

    @GetMapping("/get/{id}")
    public MovieNameAndIdObject getNameAndId(@PathVariable() Integer id){
        MovieNameAndIdObject movieNameAndIdObject = movieService.getNameAndId(id);

        return movieNameAndIdObject;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovieById(@PathVariable() Integer id){

        try {
            movieService.deleteMovieById(id);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
