package com.dev.tover.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ClientDTO {
    Integer number_of_tickets;
    UUID eventId;
    String firstName;
    String lastName;
    Double price;
}
