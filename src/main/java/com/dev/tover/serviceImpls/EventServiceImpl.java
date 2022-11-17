package com.dev.tover.serviceImpls;

import com.dev.tover.dtos.EventDTO;
import com.dev.tover.dtos.EventTypeDTO;
import com.dev.tover.dtos.ResourceNotFoundException;
import com.dev.tover.enums.EStatus;
import com.dev.tover.models.Event;
import com.dev.tover.models.EventType;
import com.dev.tover.repos.EventRepository;
import com.dev.tover.repos.EventTypeRepository;
import com.dev.tover.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EventServiceImpl implements IEventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Event create(EventDTO eventData){
        Event event = new Event();
        event.setNumber_of_seats(eventData.getNumber_of_seats());
        event.setEndDateTime(eventData.getEndDateTime());
        event.setStartDateTime(eventData.getStartDateTime());
        return eventRepository.save(event);
    };
    @Override
    public List<Event> getAll(){
        return eventRepository.findAll();
    }
    @Override
    public void delete(UUID id){
        Event event = eventRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Event","id", id.toString()));
        eventRepository.delete(event);
    }
    @Override
    public Event get(UUID id){
       return eventRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Event","id", id.toString()));
    }
    @Override
    public Event end(UUID id){
        Event event = eventRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Event","id", id.toString()));
        event.setStatus(EStatus.ENDED);
        return eventRepository.save(event);
    }
    @Override
    public Event update(List<EventTypeDTO> eventTypeDTOs, UUID eventId){
        Event event = eventRepository.findById(eventId).orElseThrow(()-> new ResourceNotFoundException("Event","id",eventId.toString()));
        List<EventType> eventTypes = new ArrayList<>();
        for (EventTypeDTO eventTypeDTO: eventTypeDTOs){
            EventType eventType = new EventType();
            eventType.setName(eventTypeDTO.getName());
            eventType.setPrice(eventTypeDTO.getPrice());
            eventType.setEvent(event);
            eventTypes.add(eventTypeRepository.save(eventType));
        }
        event.setEventTypes(eventTypes);
        return eventRepository.save(event);
    }
}
