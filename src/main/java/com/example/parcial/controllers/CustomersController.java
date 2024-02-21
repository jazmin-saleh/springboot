package com.example.parcial.controllers;

import com.example.parcial.Services.CustomersServices;
import com.example.parcial.entities.Customers;
import com.example.parcial.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersServices customersServices;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try{
            List<Customers> result = customersServices.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result );
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try{
            Customers customer = customersServices.findById(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, customer);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody Customers customer) {
        try {
            Customers savedCustomer = customersServices.save(customer);
            return ResponseHandler.generateResponse("Customer saved successfully", HttpStatus.CREATED, savedCustomer);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try{
            Customers customer = customersServices.findById(id);
            if(customer != null){
                customersServices.delete(customer);
                return  ResponseHandler.generateResponse("Succes", HttpStatus.OK, customer);
            }
            return  ResponseHandler.generateResponse("Succes Department", HttpStatus.NOT_FOUND, null);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
