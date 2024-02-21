package com.example.parcial.Services;

import com.example.parcial.entities.Customers;
import com.example.parcial.entities.Products;
import com.example.parcial.entities.Sales;
import com.example.parcial.repositories.CustomersRepository;
import com.example.parcial.repositories.ProductsRepository;
import com.example.parcial.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SalesServices {

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CustomersRepository customersRepository;

    public Sales save(Sales sales){
        return salesRepository.save(sales);
    }

    public Customers getCustomers(Sales sales){
        return sales.getCustomers();
    }

    public Set<Products> getproducts(Sales sales){
        return sales.getProducts();
    }

    public Sales createSale(int customerId, int productId, int quantity) throws Exception {
        Customers customer = customersRepository.findById(customerId)
                .orElse(null);

        Products product = productsRepository.findById(productId)
                .orElse(null);

        if (customer == null) {
            throw new Exception("no customer");
        }

        if (product == null) {
            throw new Exception("no product");
        }

        if (quantity <= 0) {
            throw new Exception("invalid quantity");
        }

        if (product.getStock() < quantity) {
         throw new Exception("no stock");
        }

        Sales sale = new Sales();
        sale.setCustomers(customer);
        sale.addProduct(product);


        product.setStock(product.getStock() - quantity);
        productsRepository.save(product);

        return salesRepository.save(sale);
    }

}
