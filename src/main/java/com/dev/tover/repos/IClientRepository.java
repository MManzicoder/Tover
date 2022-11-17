package com.dev.tover.repos;

import com.dev.tover.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IClientRepository extends JpaRepository<Client, UUID> {
}
