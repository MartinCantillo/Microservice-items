package com.martin.cloud.items.msv_items.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private long id;

    private String name;

    private Double price;
    private int product;
}
