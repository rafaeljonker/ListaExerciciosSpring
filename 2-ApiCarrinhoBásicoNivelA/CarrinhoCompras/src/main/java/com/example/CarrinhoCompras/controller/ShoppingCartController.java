package com.example.CarrinhoCompras.controller;

import com.example.CarrinhoCompras.model.Product;
import com.example.CarrinhoCompras.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;


    @PostMapping("total")
    public double getCartPrice(@RequestBody List<Product> products){
        return shoppingCartService.calculateTotal(products);
    }
}
