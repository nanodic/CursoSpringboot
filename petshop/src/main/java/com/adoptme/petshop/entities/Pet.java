package com.adoptme.petshop.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table (name="pets")
@NoArgsConstructor @ToString @EqualsAndHashCode
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter private Long id;

    @Setter @Getter private String name;
    @Setter @Getter private Integer edad;

    @ManyToOne @JoinColumn(name = "owner_id")
    @Getter @Setter private User owner;


}
