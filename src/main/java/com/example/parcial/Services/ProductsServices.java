package com.example.parcial.Services;

import com.example.parcial.entities.Customers;
import com.example.parcial.entities.Products;
import com.example.parcial.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServices {

    @Autowired
    ProductsRepository productsRepository;

    public Products save(Products product){
        return productsRepository.save(product);
    }

    public List<Products> findAll(){

        return productsRepository.findAll();
    }

    public Products findById(Integer id){
        Optional<Products> optional = productsRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }
}
