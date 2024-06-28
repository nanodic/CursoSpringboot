package com.example.ecommercefinal.controllers;

import com.example.ecommercefinal.entities.Products;
import com.example.ecommercefinal.services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path="api/v1/Products")
public class ProductsController {

    @Autowired
    private ProductsServices productsServices;

    @PostMapping()
    public void saveProducts(@RequestBody Products products) {
        try {
            productsServices.saveProducts(products);
        } catch (Exception e)
        {
            System.out.println("Error de registro");
            throw new RuntimeException( "ERROR AL REGISTRAR PRODUCTO");
        }
    }

    @GetMapping()
    public List<Products> readProducts() {
        try {
            return productsServices.readProducts();

        } catch (Exception e) {
            System.out.println("Error de registro");
            throw new RuntimeException("ERROR AL BUSCAR PRODUCTOS");
        }
    }

    @GetMapping("/{id}")
    public Optional<Products> readOne(@PathVariable("id") Integer  id) {
        try {
            return productsServices.readOne(id);

        } catch (Exception e) {
            System.out.println("Error de registro");
            throw new RuntimeException("ERROR AL BUSCAR CLIENTE");
        }
    }

    @DeleteMapping("/{id}")
    public void destroyOneProduct(@PathVariable("id") Integer  id) {
        try {
            productsServices.destroyOneProduct(id);

        } catch (Exception e) {
            System.out.println("Error de registro");
            throw new RuntimeException("ERROR AL BUSCAR CLIENTE");
        }
    }

}
