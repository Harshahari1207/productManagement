package com.wipro.ProductManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ProductManagement.models.Cart;
import com.wipro.ProductManagement.models.Order;
import com.wipro.ProductManagement.repository.CartRepository;
import com.wipro.ProductManagement.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    // Place an order based on the cart
    public Order placeOrder(Long cartId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isPresent()) {
            Order order = new Order();
            order.setProducts(cartOptional.get().getProducts());
            return orderRepository.save(order);
        }
        
        throw new RuntimeException("Cart not found");
    }

    // Retrieve an order by its ID
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
}

