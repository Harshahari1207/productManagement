package com.wipro.ProductManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ProductManagement.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

