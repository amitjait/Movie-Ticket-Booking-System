package com.bookMyShowAPI.BMS.converter;

import com.bookMyShowAPI.BMS.Model.ShowEntity;
import com.bookMyShowAPI.BMS.dto.EntryRequest.ShowEntryDto;
import com.bookMyShowAPI.BMS.dto.ResponseDto.ShowResponseDto;

public class ShowConvertor {


    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto){

        return ShowEntity.builder().showDate(showEntryDto.getShowDate()).showTime(showEntryDto.getShowTime())
                .build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity, ShowEntryDto showEntryDto){

        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showDate(showEntity.getShowDate())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theaterResponseDto(showEntryDto.getTheaterResponseDto())
                .build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity){

        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showDate(showEntity.getShowDate())
                .showTime(showEntity.getShowTime())
                .movieName(showEntity.getMovie().getName())
                .theaterName(showEntity.getTheater().getName())
                .build();
    }


}
