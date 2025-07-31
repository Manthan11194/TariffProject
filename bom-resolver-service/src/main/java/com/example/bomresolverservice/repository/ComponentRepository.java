package com.example.bomresolverservice.repository;

import com.example.bomresolverservice.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
    List<Component> findByItem_ItemId(String itemId);
}
