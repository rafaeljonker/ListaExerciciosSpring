package com.example.CarrinhoCompras.service;

import com.example.CarrinhoCompras.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    public double calculateTotal(List<Product> products){
       return products.stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();
    }

}
