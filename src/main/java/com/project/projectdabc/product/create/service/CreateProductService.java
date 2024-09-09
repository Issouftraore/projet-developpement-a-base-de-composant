package com.project.projectdabc.product.create.service;

import com.project.projectdabc.dtos.ProductRequest;
import com.project.projectdabc.entities.Category;
import com.project.projectdabc.entities.Product;
import com.project.projectdabc.repositories.CategoryRepository;
import com.project.projectdabc.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@Service
public class CreateProductService {

    private final CategoryRepository  categoryRepository;
    private final ProductRepository productRepository;

    public Product handle(ProductRequest productRequest) {
        Product product = new Product();
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
}
