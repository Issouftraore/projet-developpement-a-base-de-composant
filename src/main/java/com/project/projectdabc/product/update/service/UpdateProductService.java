package com.project.projectdabc.product.update.service;

import com.project.projectdabc.dtos.ProductRequest;
import com.project.projectdabc.entities.Category;
import com.project.projectdabc.entities.Product;
import com.project.projectdabc.repositories.CategoryRepository;
import com.project.projectdabc.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@AllArgsConstructor
public class UpdateProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product handle(Long id, ProductRequest productRequest) {
        Product product = getProductById(id);

        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());

        Set<Category> categories = new HashSet<>();
        if (productRequest.getCategoryIds() != null) {
            List<Category> categoryList = categoryRepository.findAllById(productRequest.getCategoryIds());
            categories.addAll(categoryList);
        }

        product.setCategories(categories);

        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

}
