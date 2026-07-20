package com.company.order_service.controller;

import com.company.order_service.dto.OrderRequest;
import com.company.order_service.dto.OrderResponse;
import com.company.order_service.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }


    @PostMapping
    public OrderResponse placeOrder(@RequestBody OrderRequest request){
        return service.save(request);
    }

}
