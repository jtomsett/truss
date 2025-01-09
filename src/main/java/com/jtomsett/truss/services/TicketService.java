package com.jtomsett.truss.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jtomsett.truss.dtos.Ticket;
import com.jtomsett.truss.entities.TicketEntity;
import com.jtomsett.truss.repositories.TicketRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    public Mono<Ticket> save(Ticket ticket) {

        return Mono.just(ticket)
        .mapNotNull(ticketNotNull -> this.modelMapper.map(ticketNotNull, TicketEntity.class))
        .flatMap(ticketEntity -> ticketRepository.save(ticketEntity))
        .mapNotNull(savedTicketEntity -> this.modelMapper.map(savedTicketEntity, Ticket.class));
    }

}
