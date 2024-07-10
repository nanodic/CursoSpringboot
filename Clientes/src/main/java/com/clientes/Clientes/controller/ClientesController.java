package com.clientes.Clientes.controller;

import com.clientes.Clientes.entities.Clientes;
import com.clientes.Clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Clientes> save(@RequestBody Clientes data) {
        try {
            Clientes clientes = clienteService.save(data);
            return new ResponseEntity<>(clientes, HttpStatus.CREATED);
            //La respuesta por defecto de Spring va a devolver al usuario recien creado
            // con el codigo de estado correspondiente a la creacion (201)
        }catch (Exception e)
        {
            System.out.println();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> readAll() {
        try {
            List<Clientes> users = clienteService.readAll();
            if (!users.isEmpty()) {
                return ResponseEntity.ok(users);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readOne(@PathVariable Integer id) {
        try {
            Optional<Clientes> clientes = clienteService.readOne(id);
            if (clientes.isPresent()) {
                return ResponseEntity.ok(clientes.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Integer id) {
        try {
            Optional<Clientes> optionalClientes = clienteService.readOne(id);
            if (optionalClientes.isPresent()) {
                clienteService.delete(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Clientes> updateUser(@PathVariable Integer id, @RequestBody Clientes data) {
        try {
            Optional<Clientes> optionalClientes = clienteService.readOne(id);
            if (optionalClientes.isPresent()) {
                Clientes clientes = optionalClientes.get();
                clientes.setNombre(data.getNombre());
                clientes.setApellido(data.getApellido());
                clientes.setAnios(data.getAnios());
                clientes.setDni(data.getDni());
                return ResponseEntity.ok(clienteService.save(clientes));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
