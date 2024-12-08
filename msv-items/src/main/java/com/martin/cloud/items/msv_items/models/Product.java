package com.martin.cloud.items.msv_items.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private long id;

    private String name;

    private Double price;
}
