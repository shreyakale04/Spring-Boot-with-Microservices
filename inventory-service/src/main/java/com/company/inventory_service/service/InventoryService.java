package com.company.inventory_service.service;

import com.company.inventory_service.dto.InventoryRequest;
import com.company.inventory_service.dto.InventoryResponse;
import com.company.inventory_service.mapper.InventoryMapper;
import com.company.inventory_service.model.Inventory;
import com.company.inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository){
        this.repository = repository;
    }

    public InventoryResponse save(InventoryRequest request) {

        Inventory inventory = InventoryMapper.toEntity(request);

        inventory = repository.save(inventory);

        return InventoryMapper.toResponse(inventory);
    }

    public boolean isInStock(String productId){

        Inventory inventory = repository.findByProductId(productId)
                .orElseThrow(() ->
                        new RuntimeException("Inventory Not Found"));

        return inventory.getQuantity() > 0;

    }

}
