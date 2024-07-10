package com.clientes.Clientes.repositories;

import com.clientes.Clientes.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositories extends JpaRepository<Clientes,Integer> {

}
