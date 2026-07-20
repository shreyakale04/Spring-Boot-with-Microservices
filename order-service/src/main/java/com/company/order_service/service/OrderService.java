package com.company.order_service.service;

import com.company.order_service.client.InventoryClient;
import com.company.order_service.dto.OrderRequest;
import com.company.order_service.dto.OrderResponse;
import com.company.order_service.mapper.OrderMapper;
import com.company.order_service.model.Order;
import com.company.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository repository, InventoryClient inventoryClient){
        this.repository = repository;
        this.inventoryClient = inventoryClient;
    }

    public OrderResponse save(OrderRequest request){

        boolean stock = inventoryClient.checkStock(request.productId());

        if (!stock) {
            throw new RuntimeException("Out of Stock");
        }

        //Save Order
        Order order = OrderMapper.toEntity(request);
        order = repository.save(order);

        return OrderMapper.toResponse(order);
    }


}
