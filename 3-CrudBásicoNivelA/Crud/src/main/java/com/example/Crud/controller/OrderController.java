package com.example.Crud.controller;


import com.example.Crud.model.Order;
import com.example.Crud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("createOrder")
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @GetMapping("getAllOrders")
        public List<Order> getAllOrder(){
        return orderService.listAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable long id){
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable long id, @RequestBody Order order ){
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable long id){
        orderService.deleteById(id);
    }

}
