package com.example.parcial.controllers;

import com.example.parcial.Services.SalesServices;
import com.example.parcial.entities.Sales;
import com.example.parcial.entities.SalesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesServices salesServices;

    @PostMapping
    public Sales createSale(@RequestParam("customerId") int customerId,
                            @RequestParam("productId") int productId,
                            @RequestBody SalesDTO salesDTO) throws Exception {
        Sales sale = salesServices.createSale(customerId, productId, salesDTO.getCantidad());
        System.out.println(sale);
        return sale;
    }
}
