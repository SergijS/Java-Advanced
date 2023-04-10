package com.example.ProjectShop.service.shopServiceImpl;

import com.example.ProjectShop.dto.ShopsDto;
import com.example.ProjectShop.entity.Shops;
import com.example.ProjectShop.configuration.ShopConfiguration;

import com.example.ProjectShop.repository.ShopRepository;
import com.example.ProjectShop.service.ShopService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Shops addNewShops(ShopsDto shopsDto) {
        Shops shops = modelMapper.map(shopsDto, Shops.class);
        return shopRepository.save(shops);
    }

    @Override
    public List<ShopsDto> findAllShops() {
        List<Shops> shopsList = (List<Shops>) shopRepository.findAll();
        return shopsList.stream()
                .map(shops -> modelMapper.map(shops, ShopsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ShopsDto> getShopsById(Long id) {
        Optional<Shops> shopsOptional = shopRepository.findById(id);
        return shopsOptional.map(shops -> modelMapper.map(shops, ShopsDto.class));
    }

    @Override
    public Optional<ShopsDto> replaceShopsById(Long id, ShopsDto shopsDto) {
        Optional<Shops> shopsOptional = shopRepository.findById(id);
        if (shopsOptional.isPresent()) {
            Shops shops = modelMapper.map(shopsDto, Shops.class);
            shops.setId(id);
            Shops savedShops = shopRepository.save(shops);
            return Optional.of(modelMapper.map(savedShops, ShopsDto.class));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void removeShopsById(Long id) {
        shopRepository.deleteById(id);
    }
}