package com.mif.rest.repository;

import com.mif.rest.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Orders, Long> {
}
