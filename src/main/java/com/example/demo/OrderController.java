package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

//TODO: Rest API with static data
//TODO: Rest API CRUD operation with database, Spring data

@RestController
@RequestMapping("/order")
public class OrderController {
    private static Map<String, OrderRequest> orders = new HashMap<>();

    @GetMapping("/all")
    public List<OrderRequest> getAllOrder(){
        return new ArrayList<>(orders.values());
    }

    @PostMapping("/create")
    public OrderResponse createOrder(@RequestBody OrderRequest request){
        request.setOrderId(UUID.randomUUID().toString());
        orders.put(request.getOrderId(), request);
        return new OrderResponse(request.getOrderId(), request.getOrderDate());
    }

    @PutMapping("/update")
    public OrderRequest updateOrder(@RequestBody OrderRequest request){
        String orderId = request.getOrderId();
        OrderRequest dbOrder = orders.get(orderId);
        dbOrder.setOrderDate(request.getOrderDate());
        dbOrder.setItems(request.getItems());
        dbOrder.setCustomer(request.getCustomer());
        dbOrder.setAmount(request.getAmount());
        orders.put(orderId,dbOrder);
        return dbOrder;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable String id){
        orders.remove(id);
        return "Order id "+ id +"deleted successfully";
    }
    @GetMapping("/{id}")
    public OrderRequest GetOrderById(@PathVariable String id){
        return orders.get(id);
    }

}
