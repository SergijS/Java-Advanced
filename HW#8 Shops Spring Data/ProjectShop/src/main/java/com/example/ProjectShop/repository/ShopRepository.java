package com.example.ProjectShop.repository;

import com.example.ProjectShop.entities.Shops;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shops, Long> {
}