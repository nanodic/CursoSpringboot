package com.clientes.Clientes.services;


import com.clientes.Clientes.entities.Clientes;
import com.clientes.Clientes.repositories.ClienteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired private ClienteRepositories clienteRepositories;

    public Clientes save(Clientes client)
    {
        return clienteRepositories.save(client);
    }

    public List<Clientes> readAll()
    {
        return clienteRepositories.findAll();
    }

    public Optional<Clientes> readOne (Integer id)
    {
        return clienteRepositories.findById(id);
    }

    public void delete (Integer id)
    {
        clienteRepositories.deleteById(id);
    }

}
