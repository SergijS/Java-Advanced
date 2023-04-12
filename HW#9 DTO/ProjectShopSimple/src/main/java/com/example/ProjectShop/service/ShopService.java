package com.example.ProjectShop.service;

import com.example.ProjectShop.dto.ShopsDto;
import com.example.ProjectShop.entity.Shops;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    ShopsDto addNewShops(ShopsDto shopsDto);

    Optional<ShopsDto> getShopsById(Long id);
}