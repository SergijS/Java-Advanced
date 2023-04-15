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
   public ShopsDto toDto(Shops shops){
       ShopsDto dto = new ShopsDto();
       dto.setId(shops.getId());
       dto.setCity(shops.getCity());
       dto.setStreet(shops.getStreet());
       dto.setHouseNumber(shops.getHouseNumber());
       dto.setShopName(shops.getShopName());
       dto.setHasOrNotSite(shops.isHasOrNotSite());
       return dto;
   }

   public Shops toEntity (ShopsDto shopsDto){
       Shops shops = new Shops();
       shops.setId(shopsDto.getId());
       shops.setCity(shopsDto.getCity());
       shops.setStreet(shopsDto.getStreet());
       shops.setHouseNumber(shopsDto.getHouseNumber());
       shops.setShopName(shopsDto.getShopName());
       shops.setHasOrNotSite(shopsDto.isHasOrNotSite());
       return shops;
   }
}