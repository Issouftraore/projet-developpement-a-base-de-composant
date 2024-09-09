package com.project.projectdabc.product.getProducts.service;

import com.project.projectdabc.entities.Product;
import com.project.projectdabc.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetProductsService {

    private ProductRepository productRepository;
    public List<Product> handle() {
        return productRepository.findAll();
    }
}
