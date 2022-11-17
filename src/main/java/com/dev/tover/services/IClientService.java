package com.dev.tover.services;

import com.dev.tover.dtos.ClientDTO;
import com.dev.tover.models.Client;

import java.util.UUID;

public interface IClientService {
    public Client create(ClientDTO clientDTO);
    public Client get(UUID id);
}
