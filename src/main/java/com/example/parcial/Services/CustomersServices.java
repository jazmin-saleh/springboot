package com.example.parcial.Services;

import com.example.parcial.entities.Customers;
import com.example.parcial.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServices {
    @Autowired
    CustomersRepository customersRepository;

    public List<Customers> findAll(){

        return customersRepository.findAll();
    }

    public Customers findById(Integer id){
        Optional<Customers> optional = customersRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Customers save(Customers customer){
        return customersRepository.save(customer);
    }

    public void delete( Customers customer){
        customersRepository.delete(customer);
    }

}
