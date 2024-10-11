package com.wipro.ProductManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ProductManagement.models.Cart;
import com.wipro.ProductManagement.models.Product;
import com.wipro.ProductManagement.repository.CartRepository;
import com.wipro.ProductManagement.repository.ProductRepository;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    // Add a product to the cart
    public Cart addProductToCart(Long cartId, Long productId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Optional<Product> productOptional = productRepository.findById(productId);
        
        if (cartOptional.isPresent() && productOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.getProducts().add(productOptional.get());
            return cartRepository.save(cart);
        }
        
        throw new RuntimeException("Cart or Product not found");
    }

    // Retrieve a cart by its ID
    public Optional<Cart> getCartById(Long cartId) {
        return cartRepository.findById(cartId);
    }

    // Create a new cart
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Remove a product from the cart
    public Cart removeProductFromCart(Long cartId, Long productId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Optional<Product> productOptional = productRepository.findById(productId);
        
        if (cartOptional.isPresent() && productOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.getProducts().remove(productOptional.get());
            return cartRepository.save(cart);
        }
        
        throw new RuntimeException("Cart or Product not found");
    }
}

