package com.martin.cloud.items.msv_items.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.martin.cloud.items.msv_items.clients.ProductFeignClient;
import com.martin.cloud.items.msv_items.models.Item;
import com.martin.cloud.items.msv_items.models.Product;

import feign.FeignException;

@Service
public class ItemServiceFeign implements ItemService{

    private final  ProductFeignClient client;

    public ItemServiceFeign( ProductFeignClient clientFeign){
        this.client = clientFeign;
    }

    

    @Override
    public List<Item> findAll() {
       
     return this.client.findAll().stream().map(
        product->{
           Random random = new Random();
           return new Item(product,random.nextInt( 10)+1);
        }
     ).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {

        try {
            Product product=this.client.finById(id);
            return Optional.ofNullable(new Item(product,new Random().nextInt(10)+1));
        } catch (FeignException e) {
            return Optional.empty();
        }      
    }

}
