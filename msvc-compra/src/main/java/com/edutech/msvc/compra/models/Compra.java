package com.edutech.msvc.compra.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "compras")
@Getter@Setter@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;




}
