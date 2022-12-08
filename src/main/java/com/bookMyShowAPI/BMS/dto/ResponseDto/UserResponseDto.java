package com.bookMyShowAPI.BMS.dto.ResponseDto;

import com.bookMyShowAPI.BMS.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    int id;

    String name;

    String mobNo;

    //Optional
    List<TicketDto> tickets;
}
