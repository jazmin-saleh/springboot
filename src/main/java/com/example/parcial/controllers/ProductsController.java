package com.example.parcial.controllers;

import com.example.parcial.Services.ProductsServices;
import com.example.parcial.entities.Customers;
import com.example.parcial.entities.Products;
import com.example.parcial.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsServices productsServices;
    @GetMapping
    public ResponseEntity<Object> findAll(){
        try{
            List<Products> result = productsServices.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result );
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try{
            Products products = productsServices.findById(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveproducts(@RequestBody Products products) {
        try {
            Products savedProducts = productsServices.save(products);
            return ResponseHandler.generateResponse("Product saved successfully", HttpStatus.CREATED, savedProducts);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
