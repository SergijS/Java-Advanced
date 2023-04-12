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
    public ShopsDto addNewShops(ShopsDto shopsDto) {
        Shops shops = shopConverter.toEntity(shopsDto);
        return shopConverter.toDto(shops);
    }

    @Override
    public Optional<ShopsDto> getShopsById(Long id) {
        Optional<Shops> shopsOptional = shopRepository.findById(id);
        return shopsOptional.map(shops -> shopConverter.toDto(shops));
    }
}