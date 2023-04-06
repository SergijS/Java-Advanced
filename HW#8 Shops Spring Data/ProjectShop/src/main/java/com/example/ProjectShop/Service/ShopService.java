package com.example.ProjectShop.Service;

import com.example.ProjectShop.entities.Shops;

import java.util.List;
import java.util.Optional;

public interface ShopService {
        Shops addNewShop(Shops shops);
        void deleteShopById(Long id);
        List<Shops> findAllShops();
        Optional<Shops> findShopsById(Long id);
        Shops updateShopsById(Long id, Shops shops);
    }