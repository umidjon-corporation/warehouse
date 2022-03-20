package com.project.warehouse.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDto {
    private final Boolean active;
    private String name;
    private String parentCategoryId;
}
