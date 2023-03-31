package com.example.ProjectShop.Service;

import com.example.ProjectShop.Shops.Shops;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopService {
    private Map<String, Shops> sh = new HashMap<>();

    public Shops addNewShops(Shops shops) {
        return sh.put(shops.getId(), shops);
    }

    public List<Shops> getAllShops() {
        return new ArrayList<>(sh.values());
    }

    public Shops getShopsById(String id) {
        return sh.get(id);
    }

    public Shops replaceShopsById(String id, Shops shops) {
        return sh.put(id, shops);
    }

    public Shops removeShopsById(String id) {
        return sh.remove(id);
    }
}