package com.dev.tover.controllers;

import com.dev.tover.dtos.EventDTO;
import com.dev.tover.dtos.EventTypeDTO;
import com.dev.tover.services.IEventService;
import com.dev.tover.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tover/v1/events/")
public class EventController {
    @Autowired
    private IEventService eventService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll(){
        return ResponseEntity.ok(ApiResponse.success(eventService.getAll()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getEvent(@PathVariable("id")UUID eventId){
        return ResponseEntity.ok(ApiResponse.success(eventService.get(eventId)));
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> create(@RequestBody EventDTO eventDTO){
        return ResponseEntity.ok(ApiResponse.success(eventService.create(eventDTO)));
    }
    @PutMapping("/{id}/add-event-place-types")
    public ResponseEntity<ApiResponse> updateEvent(@RequestBody List<EventTypeDTO> eventTypesDTO, @PathVariable("id") UUID eventId){
        return ResponseEntity.ok(ApiResponse.success(eventService.update(eventTypesDTO, eventId)));
    };


}
