package com.example.ecommercefinal.controllers;

import com.example.ecommercefinal.entities.Clients;
import com.example.ecommercefinal.services.ClientsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/clients")
public class ClientsController {

    @Autowired
    private ClientsServices service;

    @PostMapping()
    public void saveClient(@RequestBody Clients clients) {
        try {
            service.saveClient(clients);
        } catch (Exception e)
        {
            System.out.println("Error de registro");
            throw new RuntimeException( "ERROR AL REGISTRAR CLIENTE");
        }
    }

    @GetMapping()
    public List<Clients> readClient() {
        try {
           return service.readClient();

        } catch (Exception e) {
            System.out.println("Error de registro");
            throw new RuntimeException("ERROR AL BUSCAR CLIENTES");
        }
    }

    @GetMapping("/{id}")
    public Optional<Clients> readOne(@PathVariable("id") Integer  id) {
        try {
            return service.readOne(id);

        } catch (Exception e) {
            System.out.println("Error de registro");
            throw new RuntimeException("ERROR AL BUSCAR CLIENTE");
        }
    }

    @DeleteMapping("/{id}")
    public void destroyOneClients(@PathVariable("id") Integer  id) {
        try {
             service.destroyOneClients(id);

        } catch (Exception e) {
            System.out.println("Error de registro");
            throw new RuntimeException("ERROR AL BUSCAR CLIENTE");
        }
    }


}
