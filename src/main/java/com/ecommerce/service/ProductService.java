package com.ecommerce.service;

import com.ecommerce.dao.Product;
import com.ecommerce.dao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
     @Autowired
     private ProductRepository productRepository;
     public String createProduct(Product productRequest){
        productRepository.save(productRequest);
        return "Product Created Successfully";
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

    public String  removeProduct(Long id){
         productRepository.deleteById(id);
         return "Product delete Successfully";
    }
    public String updateProduct(Long id, Product productData){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existing = optionalProduct.get();

            if(productData.getName()!= null){
                existing.setName(productData.getName());
            }
            if(productData.getProdModel()!=null){
                existing.setProdModel(productData.getProdModel());
            }
        productRepository.save(existing);
        return "Product updated Successfully";
    }
    else{
        throw new RuntimeException("Product not found id "+id);
        }
}
public List<Product> searchProduct(String keyword){
         return productRepository.findByNameContainingIgnoreCase(keyword);
}
}
