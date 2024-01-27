package com.example.demo.order;


import com.example.demo.OrderRequest;
import com.example.demo.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//TODO: Rest API CRUD operation with database, Spring data

@RestController
@RequestMapping("/order-new")
public class NewOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<OrderRequest> getAllOrder(){
        return  orderService.getAll();
    }

    @PostMapping("/create")
    public OrderRequest createOrder(@RequestBody OrderRequest request){
        return orderService.createOrder(request);
    }

    @PutMapping("/update")
    public OrderRequest updateOrder(@RequestBody OrderRequest request){
        return orderService.updateOrder(request);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable String id){
        orderService.DeleteOrder(id);
        return "Order id "+ id +"deleted successfully";
    }
    @GetMapping("/{id}")
    public OrderRequest GetOrderById(@PathVariable String id){
        return orderService.GetOrderById(id);
    }
}
