package com.company.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductRequest(

    @NotBlank(message = "Product name is required")
    String name,

    @NotBlank(message = "Description is required")
    String description,

    @NotBlank(message = "Brand is required")
    String brand,

    @Positive(message = "Price must be greater than zero")
    Double price,

    @NotBlank(message = "Category is required")
    String category,

    @Positive(message = "Quantity must be positive")
    Integer quantity
)
{

}
