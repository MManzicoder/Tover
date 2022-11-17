package com.dev.tover.services;

import com.dev.tover.dtos.EventDTO;
import com.dev.tover.dtos.EventTypeDTO;
import com.dev.tover.models.Event;

import java.util.List;
import java.util.UUID;

public interface IEventService {
    public Event create(EventDTO event);
    public Event get(UUID eventId);
    public List<Event> getAll();
    public void delete(UUID eventId);
    public Event end(UUID eventId);

    public Event update(List<EventTypeDTO> eventTypesDTO, UUID eventId);
}
