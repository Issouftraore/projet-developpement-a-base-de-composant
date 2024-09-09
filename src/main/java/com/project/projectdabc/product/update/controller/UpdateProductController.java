package com.project.projectdabc.product.update.controller;

import com.project.projectdabc.dtos.ProductRequest;
import com.project.projectdabc.entities.Product;
import com.project.projectdabc.product.update.service.UpdateProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class UpdateProductController {
    private final UpdateProductService updateProductService;

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        Product updatedProduct = updateProductService.handle(id, productRequest);
        return ResponseEntity.ok(updatedProduct);
    }
}
