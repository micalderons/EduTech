package com.edutech.msvc.boleta.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "boletas")
@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Boleta {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idBoleta;


    @NotBlank(message = "este campo no puede estar vacio")
    @Pattern(regexp = "\\d{1,8}-{\\dKk}", message = "este campo no puede estar vacio ")
    @Column(nullable = false, unique = true)
    private String rut;

    @NotBlank(message = "el valor total de la boleta no puede ser 0")
    @Column(nullable = false)
    private Double total;

    @NotBlank(message = "este campo debe tener una fecha valida")
    @Column(nullable = false)
    private LocalDate fechaEmision;

}
