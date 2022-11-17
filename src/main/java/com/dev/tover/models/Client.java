package com.dev.tover.models;

import com.dev.tover.enums.EStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;

    private String lastName;

    private Integer number_of_tickets;

    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;

    private Double price;

}
