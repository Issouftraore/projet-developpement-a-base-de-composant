package com.project.projectdabc.dtos;

import lombok.Data;
import java.util.List;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private List<Long> categoryIds;
}
