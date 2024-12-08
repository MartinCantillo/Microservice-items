package com.martin.cloud.items.msv_items.clients;

import java.util.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.martin.cloud.items.msv_items.models.Product;

@FeignClient(url = "localhost:8081/api/product" , name = "msvc-products")
public interface ProductFeignClient {

    @GetMapping()
    List<Product>findAll();

    @GetMapping("/{id}")
    Product finById(@PathVariable Long id);
}
