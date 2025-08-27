package com.ecommerce.controller;

import com.ecommerce.dao.Product;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product prodReq){
        String response = service.createProduct(prodReq);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Long id){
       Product response = service.getProductById(id);
       return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable("id") Long id){
        String delResponse = service.removeProduct(id);
        return ResponseEntity.ok(delResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id,@RequestBody Product productData){
        String uptodate = service.updateProduct(id,productData);
        return ResponseEntity.ok(uptodate);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@PathVariable("search") @RequestParam String keyword){
        return ResponseEntity.ok(service.searchProduct(keyword));
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Product>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(service.getProducts(page, size, sortBy));
    }
}
