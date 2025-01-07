package com.jtomsett.truss.dtos;

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
public class Ticket {

    @NotBlank
    @Size(max = 512)
    @Getter
    @Setter
    private String title;
}
