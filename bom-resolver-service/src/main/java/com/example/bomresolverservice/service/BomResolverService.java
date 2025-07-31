package com.example.bomresolverservice.service;

import com.example.bomresolverservice.entity.Item;
import com.example.bomresolverservice.entity.Component;
import com.example.bomresolverservice.repository.ItemRepository;
import com.example.bomresolverservice.repository.ComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BomResolverService {

    private final ItemRepository itemRepository;
    private final ComponentRepository componentRepository;

    public BomResolverService(ItemRepository itemRepository, ComponentRepository componentRepository) {
        this.itemRepository = itemRepository;
        this.componentRepository = componentRepository;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemByItemId(String itemId) {
        return itemRepository.findByItemId(itemId);
    }

    public List<Component> getComponentsByItemId(String itemId) {
        return componentRepository.findByItem_ItemId(itemId);
    }

    public Component addComponentToItem(String itemId, Component component) {
        Item item = itemRepository.findByItemId(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
        component.setItem(item);
        return componentRepository.save(component);
    }
}
