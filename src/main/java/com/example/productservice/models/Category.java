package com.example.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel{
    private String title;
    private String description;
}
