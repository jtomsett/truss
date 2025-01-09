package com.jtomsett.truss.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.jtomsett.truss.entities.TicketEntity;

@Repository
public interface TicketRepository extends R2dbcRepository<TicketEntity,Integer>{
}
