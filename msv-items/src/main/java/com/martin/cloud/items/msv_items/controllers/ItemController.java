package com.martin.cloud.items.msv_items.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.cloud.items.msv_items.models.Item;
import com.martin.cloud.items.msv_items.services.ItemService;

@RequestMapping("/api/item")
@RestController
public class ItemController {

    private final ItemService itemService;

    //Qualifier allows to aim at  to the bean reference or to the specific implementation of this interface  
    public ItemController(@Qualifier("itemServiceWebClient")ItemService itemServices) {
        this.itemService = itemServices;
    }

    @GetMapping
    public List<Item> finAll() {
        return this.itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Optional<Item> itemOptional = this.itemService.findById(id);
        if (itemOptional.isPresent()) {

            return ResponseEntity.ok(itemOptional.get());
        }
        return ResponseEntity.status(404).body(Collections.singletonMap("mesage", "Not found Product "));
    }

}
