package com.company.inventory_service.controller;

import com.company.inventory_service.dto.InventoryRequest;
import com.company.inventory_service.dto.InventoryResponse;
import com.company.inventory_service.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service){
        this.service = service;
    }
    @PostMapping

    public InventoryResponse save(@RequestBody InventoryRequest request){
        return service.save(request);
    }

    @GetMapping("/{productId}")
    public boolean checkStock(
            @PathVariable String productId){

        return service.isInStock(productId);

    }
}
