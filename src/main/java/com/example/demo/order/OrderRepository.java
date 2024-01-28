package com.example.demo.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity,String> {
    List<OrderEntity> findByOrderDate(Date date);
}
