package com.example.bomresolverservice.controller;

import com.example.bomresolverservice.entity.Component;
import com.example.bomresolverservice.entity.Item;

import com.example.bomresolverservice.service.BomResolverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bom")
public class BomResolverController {

    private final BomResolverService bomService;

    public BomResolverController(BomResolverService bomService) {
        this.bomService = bomService;
    }


    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return ResponseEntity.ok(bomService.createItem(item));
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(bomService.getAllItems());
    }

    @GetMapping("/items/{itemId}/components")
    public ResponseEntity<List<Component>> getComponents(@PathVariable String itemId) {
        return ResponseEntity.ok(bomService.getComponentsByItemId(itemId));
    }

    @PostMapping("/items/{itemId}/components")
    public ResponseEntity<Component> addComponent(@PathVariable String itemId, @RequestBody Component component) {
        return ResponseEntity.ok(bomService.addComponentToItem(itemId, component));
    }
}
