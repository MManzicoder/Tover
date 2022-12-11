package com.dev.tover.serviceImpls;

import com.dev.tover.dtos.ClientDTO;
import com.dev.tover.dtos.ResourceNotFoundException;
import com.dev.tover.models.Client;
import com.dev.tover.models.Event;
import com.dev.tover.repos.EventRepository;
import com.dev.tover.repos.IClientRepository;
import com.dev.tover.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientServiceServiceImpl implements IClientService {
    @Autowired
    private IClientRepository clientRepository;
    @Autowired
    private EventRepository eventRepository;


    @Override
    public Client create(ClientDTO clientDTO){
        Event event = eventRepository.findById(clientDTO.getEventId()).orElseThrow(()->new ResourceNotFoundException("Event","id",clientDTO.getEventId().toString()));
        Client client = new Client(clientDTO.getFirstName(),clientDTO.getLastName(),clientDTO.getNumber_of_tickets(),event,clientDTO.getPrice());
        return clientRepository.save(client);
    }

    @Override
    public Client get(UUID id){
        Client client = clientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Client","id", id.toString()));
        return clientRepository.save(client);
    }
}
