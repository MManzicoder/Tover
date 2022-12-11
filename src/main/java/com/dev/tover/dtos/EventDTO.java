package com.dev.tover.dtos;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class EventDTO {
     Integer number_of_seats;

     LocalDateTime startDateTime;

     LocalDateTime endDateTime;
     public EventDTO(Integer number_of_seats, LocalDateTime startDateTime, LocalDateTime endDateTime){
          this.number_of_seats= number_of_seats;
          this.startDateTime=startDateTime;
          this.endDateTime = endDateTime;
     }

}
