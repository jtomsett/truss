package com.jtomsett.truss.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Table(name = "ticket")
public class TicketEntity {

    @Id
    private int id;

    @NotBlank
    @Size(max = 512)
    @Getter
    @Setter
    private String title;

}
