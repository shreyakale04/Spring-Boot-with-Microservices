package com.company.inventory_service.mapper;

import com.company.inventory_service.dto.InventoryRequest;
import com.company.inventory_service.dto.InventoryResponse;
import com.company.inventory_service.model.Inventory;

public class InventoryMapper {

    public static Inventory toEntity(InventoryRequest request){
        return Inventory.builder()
                .productId(request.productId())
                .quantity(request.quantity())
                .build();
    }

    public static InventoryResponse toResponse(Inventory inventory){
        return new InventoryResponse(

                inventory.getId(),

                inventory.getProductId(),

                inventory.getQuantity()
        );
    }
}
