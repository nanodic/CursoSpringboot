package com.adoptme.petshop.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor @EqualsAndHashCode @ToString
public class User {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
@Getter @Setter private Long id;

    @Getter @Setter private String name;
    @Getter @Setter private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter @Setter private List<Pet> pets;
}
