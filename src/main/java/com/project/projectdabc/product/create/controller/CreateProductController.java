package com.project.projectdabc.product.create.controller;

import com.project.projectdabc.dtos.ProductRequest;
import com.project.projectdabc.entities.Product;
import com.project.projectdabc.product.create.service.CreateProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class CreateProductController {

 private final CreateProductService createProductService;
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
        Product product = createProductService.handle(productRequest);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
