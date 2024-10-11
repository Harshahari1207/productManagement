package com.wipro.ProductManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ProductManagement.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}

