package com.martin.cloud.items.msv_items.services;

import java.util.*;

import com.martin.cloud.items.msv_items.models.Item;

public interface ItemService {

    List<Item>findAll();

    Optional<Item>findById(Long id);
}
