package com.example.ProjectShop.service.shopServiceImpl;

import com.example.ProjectShop.converter.ShopConverter;
import com.example.ProjectShop.dto.ShopsDto;
import com.example.ProjectShop.entity.Shops;
import com.example.ProjectShop.repository.ShopRepository;
import com.example.ProjectShop.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

    @Autowired
    private final ShopRepository shopRepository;
    @Autowired
    private final ShopConverter shopConverter;

    @Override
    public Shops addNewShops(ShopsDto shopsDto) {
        return shopRepository.save(shopConverter.toEntity(shopsDto));
    }

    @Override
    public ShopsDto getShopById(Long id) {
        Shops shop = shopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This id is not here"));
        return shopConverter.toDto(shop);
    }
}