package com.example.ProjectShop.Service;

import com.example.ProjectShop.entities.Shops;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {
    private final Map<Long, Shops> sh = new HashMap<>();

    @Override
    public Shops addNewShop(Shops shops) {
        return sh.put(shops.getId(), shops);
    }

    @Override
    public void deleteShopById(Long id) {
        sh.remove(id);
    }

    @Override
    public List<Shops> findAllShops() {
        return new ArrayList<>(sh.values());
    }

    @Override
    public Optional<Shops> findShopsById(Long id) {
        return Optional.ofNullable(sh.get(id));
    }

    @Override
    public Shops updateShopsById(Long id, Shops shops) {
        if (sh.containsKey(id)) {
            shops.setId(id);
            sh.put(id, shops);
            return shops;
        } else {
            return null;
        }
    }
}