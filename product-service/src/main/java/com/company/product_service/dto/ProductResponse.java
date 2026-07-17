package com.company.product_service.dto;

public record ProductResponse(
        String id,

        String name,

        String description,

        String brand,

        Double price,

        String category,

        Integer quantity
) {
}
