package com.example.demo;

import com.example.demo.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,String> {

    List<OrderEntity> findByOrderDate(Date date);
}
