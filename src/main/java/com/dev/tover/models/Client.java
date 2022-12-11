package com.dev.tover.models;

import com.dev.tover.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    public Client(String firstName, String lastName, Integer number_of_tickets,Event event, Double price){
        this.firstName=firstName;
        this.lastName=lastName;
        this.number_of_tickets=number_of_tickets;
        this.event=event;
        this.price=price;
    }

}
