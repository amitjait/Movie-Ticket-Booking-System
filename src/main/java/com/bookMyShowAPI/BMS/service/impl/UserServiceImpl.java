package com.bookMyShowAPI.BMS.service.impl;

import com.bookMyShowAPI.BMS.Model.UserEntity;
import com.bookMyShowAPI.BMS.Repository.UserRepository;
import com.bookMyShowAPI.BMS.converter.UserConverter;
import com.bookMyShowAPI.BMS.dto.EntryRequest.UserEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.UserResponseDto;
import com.bookMyShowAPI.BMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userEntryDto) {

        UserEntity userEntity = UserConverter.convertDtoToEntity(userEntryDto); //Cleaner
        userEntity = userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {

        UserEntity user = new UserEntity(); //By default user.

        UserEntity userEntity = userRepository.findById(id).get();

        UserResponseDto userResponseDto = UserConverter.convertEntityToDto(userEntity);

        return userResponseDto;
    }
}
