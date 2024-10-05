package com.example.Crud.service;

import com.example.Crud.model.Order;
import com.example.Crud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> listAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    public Order updateOrder(Long id, Order orderDetails) {

        Order order = getOrderById(id);
        if (order != null) {
            order.setName(orderDetails.getName());
            order.setQuantity(orderDetails.getQuantity());
            order.setPrice(orderDetails.getPrice());
            return orderRepository.save(order);
        } else {
            return null;
        }
    }

    public void deleteById(Long id){
        orderRepository.deleteById(id);
    }

}
