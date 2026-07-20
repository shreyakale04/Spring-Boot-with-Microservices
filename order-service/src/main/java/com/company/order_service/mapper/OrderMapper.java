package com.company.order_service.mapper;

import com.company.order_service.dto.OrderRequest;
import com.company.order_service.dto.OrderResponse;
import com.company.order_service.model.Order;

public class OrderMapper {

public static Order toEntity(OrderRequest request){

    Order order = new Order();

    order.setProductId(request.productId());
    order.setQuantity(request.quantity());

    order.setPrice(request.price());

    order.setTotalAmount(request.quantity()*request.price());

    return order;
}
    public static OrderResponse toResponse(Order order) {

        return new OrderResponse(
                order.getId(),
                order.getProductId(),
                order.getQuantity(),
                order.getPrice(),
                order.getTotalAmount()
        );
    }


}
