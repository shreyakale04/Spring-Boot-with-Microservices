package com.company.product_service.controller;

import com.company.product_service.dto.ProductRequest;
import com.company.product_service.model.Product;
import com.company.product_service.repository.ProductRepository;
import com.company.product_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pro")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service){

        this.service = service;
    }

    @PostMapping

    public Product save(@RequestBody Product product){
        return service.save(product);
    }

    @GetMapping
    public List<Product> getAll(){

        return service.getAllProducts();

    }

//    @GetMapping("/{id}")
//    public Product getById(@PathVariable String id){
//
//        return service.getProduct(id);
//
//    }
@DeleteMapping("/{id}")
public void delete(@PathVariable String id){

    service.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @Valid @RequestBody ProductRequest request){
        return service.updateProduct(id,request);
    }

    @GetMapping("/brand/{brand}")

    public List<Product>getByBrand(@PathVariable String brand){
        return service.getByBrand(brand);
    }
    @GetMapping("/category/{category}")

    public List<Product>getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/page")
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return service.getAllProducts(pageable);


    }

}
