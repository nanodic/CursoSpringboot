package com.clientes.Clientes.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name="CLIENTES")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Clientes {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Getter @Setter private String nombre;
    @Getter @Setter private String apellido;
    @Getter @Setter private String dni;
    @Getter @Setter private Integer anios;


}
