package com.bookMyShowAPI.BMS.controller;

import com.bookMyShowAPI.BMS.dto.EntryRequest.UserEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.UserResponseDto;
import com.bookMyShowAPI.BMS.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody() UserEntryDto userEntryDto){

        userService.addUser(userEntryDto);

        return new ResponseEntity("Added a success User", HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value = "id")int id){

        UserResponseDto userResponseDto = userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

}
