package com.adoptme.petshop.services;

import com.adoptme.petshop.entities.User;
import com.adoptme.petshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired private UserRepository userRepository;

    public User save(User user)
    {
        return userRepository.save(user);
    }

    public List<User> readAll()
    {
        return userRepository.findAll();
    }

    public Optional<User> readOne (Long id)
    {
        return userRepository.findById(id);
    }

    public void delete (Long id)
    {
        userRepository.deleteById(id);
    }

}
