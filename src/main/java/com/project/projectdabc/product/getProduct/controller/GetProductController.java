package com.project.projectdabc.product.getProduct.controller;

import com.project.projectdabc.entities.Product;
import com.project.projectdabc.product.update.controller.UpdateProductController;
import com.project.projectdabc.product.update.service.UpdateProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetProductController {

    private final UpdateProductService updateProductService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(updateProductService.getProductById(id));
    }
}
