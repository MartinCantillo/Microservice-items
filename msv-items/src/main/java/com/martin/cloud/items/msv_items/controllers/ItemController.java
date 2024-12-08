package com.martin.cloud.items.msv_items.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.martin.cloud.items.msv_items.services.ItemService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martin.cloud.items.msv_items.models.Item;

@RequestMapping("/api/item")
@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemServices){
        this.itemService=itemServices;
    }

    @GetMapping
    public List<Item> finAll() {
        return this.itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.itemService.findById(id).orElseThrow());
    }
    
    
}
