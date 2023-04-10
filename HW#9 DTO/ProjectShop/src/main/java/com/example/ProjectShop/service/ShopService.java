package com.example.ProjectShop.service;

import com.example.ProjectShop.dto.ShopsDto;
import com.example.ProjectShop.entity.Shops;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    Shops addNewShops(ShopsDto shopsDto);
    List<ShopsDto> findAllShops();
    Optional<ShopsDto> getShopsById(Long id);
    Optional<ShopsDto> replaceShopsById(Long id, ShopsDto shopsDto);
    void removeShopsById(Long id);

}

