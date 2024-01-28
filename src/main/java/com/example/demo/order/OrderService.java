package com.example.demo.order;

import com.example.demo.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Value("${spring.datasource.username}")
    private String dbUser;
    @Autowired
    private OrderRepository repository;
    public List<OrderRequest> getAll(){
        List<OrderRequest> requests = new ArrayList<>();
        var dbOrders =  repository.findAll();
        for(OrderEntity order : dbOrders){
            requests.add(toRequest(order));
        }
        return requests;
    }

    public OrderRequest createOrder(OrderRequest request){
        var dbOrder = new OrderEntity();
        dbOrder.setOrderId(UUID.randomUUID().toString());
        dbOrder.setOrderDate(request.getOrderDate());
        dbOrder.setItems(String.join(",",request.getItems()));
        dbOrder.setCustomer(request.getCustomer());
        dbOrder.setAmount(request.getAmount());
        repository.save(dbOrder);

        request.setOrderId(dbOrder.getOrderId());
        return request;
    }
    public OrderRequest updateOrder(OrderRequest request){
        var dbOrder1 = repository.findById(request.getOrderId());
        if(dbOrder1.isPresent()) {
            var dbOrder  = dbOrder1.get();
            dbOrder.setOrderId(UUID.randomUUID().toString());
            dbOrder.setOrderDate(request.getOrderDate());
            dbOrder.setItems(String.join(",",request.getItems()));
            dbOrder.setCustomer(request.getCustomer());
            dbOrder.setAmount(request.getAmount());
            repository.save(dbOrder);
        }
        return request;
    }
     public void DeleteOrder(String orderId){
        repository.deleteById(orderId);
     }
    public OrderRequest GetOrderById(String orderId){
        var  entity = repository.findById(orderId).get();
        return toRequest(entity);
    }
    private OrderRequest toRequest(OrderEntity entity){
        var request  = new OrderRequest();
        request.setItems(List.of(entity.getItems().split(",")));
        request.setCustomer(entity.getCustomer());
        request.setOrderDate(entity.getOrderDate());
        request.setOrderId(entity.getOrderId());
        request.setAmount(entity.getAmount());
        return request;
    }

}
