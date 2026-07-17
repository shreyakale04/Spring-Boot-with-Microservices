package com.company.product_service.mapper;

import com.company.product_service.dto.ProductRequest;
import com.company.product_service.dto.ProductResponse;
import com.company.product_service.model.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequest request){

        Product product = new Product();

        product.setName(request.name());
        product.setDescription(request.description());
        product.setBrand(request.brand());
        product.setPrice(request.price());
        product.setCategory(request.category());
        product.setQuantity(request.quantity());

        return product;
    }

    public static ProductResponse toResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getPrice(),
                product.getCategory(),
                product.getQuantity()
        );
    }
}
