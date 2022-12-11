package com.dev.tover.controller;

import com.dev.tover.controllers.EventController;
import com.dev.tover.dtos.EventDTO;
import com.dev.tover.models.Event;
import com.dev.tover.utils.ApiResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.time.LocalDateTime;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
public class EventControllerTest {
    @MockBean
    private EventController eventControllerMock;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllEvents() throws Exception {
      //when getAll method is called let's assign data to be returned as an empty list
        when(eventControllerMock.getAll()).thenReturn(ResponseEntity.ok(ApiResponse.success(new ArrayList<Event>())));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/tover/v1/events")
                .accept(MediaType.APPLICATION_JSON);

         mockMvc
                 .perform(request)
                 .andExpect(status().isOk())
                 .andExpect((ResultMatcher) content().json("[]"))
                 .andReturn();

    }
    @Test
    public void getEventThatDoesNotExists() throws Exception {
       Event event = new Event(50,LocalDateTime.parse("25/12/2022"), LocalDateTime.parse("26/12/2022"));

        when(eventControllerMock.getEvent(event.getId())).thenReturn(ResponseEntity.ok(ApiResponse.success(event)));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/tover/v1/events/2")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(request)
                .andExpect(status().isNotFound())
                .andExpect((ResultMatcher) content().json("{\"status\":true,\"message\":null,\"data\": null}"))
                .andReturn();

    }
    @Test
    public void getEventWhichDoesNotExits() {
        ResponseEntity<ApiResponse> response =
                this.restTemplate.getForEntity("/api/tover/v1/events/2", ApiResponse.class);

        assertTrue(response.getStatusCodeValue()==404);
        assertFalse(response.getBody().getSuccess());
    }
    @Test
    public void createEvent(){
        EventDTO eventDTO = new EventDTO(50,LocalDateTime.parse("25/12/2022"), LocalDateTime.parse("26/12/2022"));

        Event event = new Event(50,LocalDateTime.parse("25/12/2022"), LocalDateTime.parse("26/12/2022"));

        when(eventControllerMock.create(eventDTO)).thenReturn(ResponseEntity.ok(ApiResponse.success(event)));

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/tover/v1/events",eventDTO,ApiResponse.class);

        assertTrue(response.getBody().getSuccess());

        assertEquals(response.getBody().getData(),event);
    }
}
