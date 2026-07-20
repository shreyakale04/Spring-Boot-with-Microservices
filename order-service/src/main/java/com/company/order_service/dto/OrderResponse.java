package com.company.order_service.dto;

public record OrderResponse(String id,

                            String productId,

                            Integer quantity,

                            Double price,

                            Double totalAmount)
{
}
