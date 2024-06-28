package com.example.ecommercefinal.services;

import com.example.ecommercefinal.entities.Clients;
import com.example.ecommercefinal.entities.Products;
import com.example.ecommercefinal.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServices {
    @Autowired
    private ProductsRepository repository;

    public void saveProducts(Products products)
    {
        repository.save(products);
    }

    public List<Products> readProducts()
    {
        return repository.findAll();
    }

    public Optional<Products> readOne(Integer id)
    {
        return repository.findById(id);
    }

    public void destroyOneProduct(Integer id)
    {
        repository.deleteById(id);
    }

}
