package com.orion.shop.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imageName;
    private Long categoryId;
}
