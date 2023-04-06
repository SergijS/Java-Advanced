package com.example.ProjectShop.Controller;

import com.example.ProjectShop.Service.ShopServiceImpl;
import com.example.ProjectShop.entities.Shops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/shops")

public class ShopController {
    @Autowired
    private final ShopServiceImpl shopService;


    public ShopController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<Shops> addNewShops(@RequestBody Shops shops) {
        Shops newShops = shopService.addNewShop(shops);
        return new ResponseEntity<>(newShops, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Shops>> getAllShops() {
        List<Shops> allShops = shopService.findAllShops();
        return new ResponseEntity<>(allShops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shops> getShopsById(@PathVariable Long id) {
        Optional<Shops> shops = shopService.findShopsById(id);
        if (shops != null) {
            return new ResponseEntity<>(shops.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shops> replaceShopsById(@PathVariable Long id, @RequestBody Shops shops) {
        Shops replaceShops = shopService.updateShopsById(id, shops);
        if (replaceShops != null) {
            return new ResponseEntity<>(replaceShops, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeShopsById(@PathVariable Long id) {
        shopService.deleteShopById(id);
        return ResponseEntity.noContent().build();
    }
}