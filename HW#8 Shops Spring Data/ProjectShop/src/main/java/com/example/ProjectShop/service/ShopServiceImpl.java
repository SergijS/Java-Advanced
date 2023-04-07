package com.example.ProjectShop.service;

import com.example.ProjectShop.entities.Shops;

import com.example.ProjectShop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Shops addNewShop(Shops shops) {
        return shopRepository.save(shops);
    }

    @Override
    public void deleteShopById(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public List<Shops> findAllShops() {
        return (List<Shops>) shopRepository.findAll();
    }

    @Override
    public Optional<Shops> findShopsById(Long id) {
        if (id != null) {
            return shopRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Shops updateShopsById(Long id, Shops shops) {
        Optional<Shops> optionalShops = shopRepository.findById(id);
        if (optionalShops.isPresent()) {
            Shops deletShops = optionalShops.get();
            deletShops.setCity(shops.getCity());
            deletShops.setStreet(shops.getStreet());
            deletShops.setHouseNumber(shops.getHouseNumber());
            deletShops.setShopName(shops.getShopName());
            deletShops.setNumberOfEmployees(shops.getNumberOfEmployees());
            deletShops.setHasOrNotSite(shops.isHasOrNotSite());
            return shopRepository.save(deletShops);
        } else {
            return null;
        }
    }
}