package com.company.order_service.dto;

public record OrderRequest(String productId,

                           Integer quantity,

                           Double price)
{
}
