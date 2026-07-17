package com.company.product_service.service;

import com.company.product_service.dto.ProductRequest;
import com.company.product_service.exception.ProductNotFoundException;
import com.company.product_service.model.Product;
import com.company.product_service.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

//    public Product getProduct(String id) {
//
//        return repository.findById(id)
//
//                .orElseThrow(() ->
//                        new ProductNotFoundException("Product not found"));

    //    }
    public void deleteProduct(String id) {

        repository.deleteById(id);

    }

    public Product updateProduct(String id, ProductRequest request) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found"));

        product.setName(request.name());
        product.setDescription(request.description());
        product.setBrand(request.brand());
        product.setPrice(request.price());
        product.setCategory(request.category());
        product.setQuantity(request.quantity());

        return repository.save(product);
    }

    public List<Product> getByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    public List<Product> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }
}