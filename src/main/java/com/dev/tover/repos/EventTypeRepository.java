package com.dev.tover.repos;

import com.dev.tover.models.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, UUID> {
}
