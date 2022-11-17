package com.dev.tover.serviceImpls;

import com.dev.tover.dtos.ClientDTO;
import com.dev.tover.dtos.ResourceNotFoundException;
import com.dev.tover.models.Client;
import com.dev.tover.repos.IClientRepository;
import com.dev.tover.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService implements IClientService {
    @Autowired
    private IClientRepository clientRepository;


    @Override
    public Client create(ClientDTO clientDTO){
        Client client = new Client();
        return clientRepository.save(client);
    }

    @Override
    public Client get(UUID id){
        Client client = clientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Client","id", id.toString()));
        return clientRepository.save(client);
    }
}
