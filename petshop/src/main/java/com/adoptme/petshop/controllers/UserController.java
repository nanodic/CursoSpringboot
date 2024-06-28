package com.adoptme.petshop.controllers;

import com.adoptme.petshop.entities.User;
import com.adoptme.petshop.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User data) {
        try {
            User user = userServices.save(data);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
            //La respuesta por defecto de Spring va a devolver al usuario recien creado
            // con el codigo de estado correspondiente a la creacion (201)
        }catch (Exception e)
        {
            System.out.println();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        }

}
