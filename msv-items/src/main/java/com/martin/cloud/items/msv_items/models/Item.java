package com.martin.cloud.items.msv_items.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Product product;

    private int quantity;

    public Double getTotal(){
        return product.getPrice() * quantity;
    }

}
