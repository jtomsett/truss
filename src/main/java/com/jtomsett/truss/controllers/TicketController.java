package com.jtomsett.truss.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jtomsett.truss.dtos.Ticket;
import com.jtomsett.truss.services.TicketService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "submit new ticket")
    })
    @PostMapping("/submit")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Ticket> submitTicket(@RequestBody Ticket ticket){
        return ticketService.save(ticket);
    }

}
