package com.example.ProjectShop.converter;

import com.example.ProjectShop.dto.ShopsDto;
import com.example.ProjectShop.entity.Shops;
import com.example.ProjectShop.service.ShopService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ShopConverter {
    private final ModelMapper modelMapper;

    public ShopsDto toDto(Shops shops) {
        return modelMapper.map(shops, ShopsDto.class);
    }

    public Shops toEntity(ShopsDto shopsDto) {
        return modelMapper.map(shopsDto, Shops.class);
    }
}