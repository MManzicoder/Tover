package com.dev.tover.dtos;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class EventDTO {
     Integer number_of_seats;

     LocalDateTime startDateTime;

     LocalDateTime endDateTime;

}
