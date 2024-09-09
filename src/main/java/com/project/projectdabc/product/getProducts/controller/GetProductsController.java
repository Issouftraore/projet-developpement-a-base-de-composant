package com.project.projectdabc.product.getProducts.controller;

import com.project.projectdabc.entities.Product;
import com.project.projectdabc.product.getProducts.service.GetProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class GetProductsController {
    private final GetProductsService getProductsService;

    @GetMapping
    public List<Product> getAllProducts() {
        return getProductsService.handle();
    }
}
