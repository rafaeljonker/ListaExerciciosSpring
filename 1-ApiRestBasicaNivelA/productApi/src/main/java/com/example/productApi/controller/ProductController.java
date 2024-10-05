package com.example.productApi.controller;


import com.example.productApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

 @GetMapping("produtos")
 public List<Product> getProduto(){
  return Arrays.asList(new Product("Carro", "Carro veloz", 200.0), new Product("Moto", "Veloz", 500.0));

 }

}
