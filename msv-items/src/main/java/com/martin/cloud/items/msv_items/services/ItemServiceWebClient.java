package com.martin.cloud.items.msv_items.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import org.springframework.web.reactive.function.client.WebClient;

import com.martin.cloud.items.msv_items.models.Item;

@Primary
@Service
public class ItemServiceWebClient  implements  ItemService{


    private final WebClient.Builder client;

    
    public ItemServiceWebClient(Builder client) {
        this.client = client;
    }

    @Override
    public List<Item> findAll() {
    return this.client.build()
    .get()
    .uri("http://msvc-products") 
    .accept(MediaType.APPLICATION_JSON)
    .retrieve()
    .bodyToFlux(Item.class)
    .collectList()
    .block();
    }

    @Override
    public Optional<Item> findById(Long id) {

        Map<String,Long> params=new HashMap<>();
        params.put("id", id);

        return Optional.ofNullable(
            this.client.build()
            .get()
            .uri("http://msvc-products7{id}",params)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Item.class)
            .block()
        );
    
    }

}
