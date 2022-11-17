package com.dev.tover.models;

import com.dev.tover.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer number_of_seats;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @ManyToMany
    @JoinTable(name = "event_client", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    @JsonIgnoreProperties("event")
    private List<EventType> eventTypes = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private EStatus status;
}
