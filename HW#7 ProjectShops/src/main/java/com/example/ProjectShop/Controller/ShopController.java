package com.example.ProjectShop.Controller;

import com.example.ProjectShop.Service.ShopService;
import com.example.ProjectShop.Shops.Shops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/shops")

public class ShopController {
    @Autowired
    private final ShopService shopService;


    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<Shops> addNewShops(@RequestBody Shops shops) {
        Shops newShops = shopService.addNewShops(shops);
        return new ResponseEntity<>(newShops, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Shops>> getAllShops() {
        List<Shops> allShops = shopService.getAllShops();
        return new ResponseEntity<>(allShops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shops> getShopsById(@PathVariable String id) {
        Shops shops = shopService.getShopsById(id);
        if (shops != null) {
            return new ResponseEntity<>(shops, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shops> replaceShopsById(@PathVariable String id, @RequestBody Shops shops) {
        Shops replaceShops = shopService.replaceShopsById(id, shops);
        if (replaceShops != null) {
            return new ResponseEntity<>(replaceShops, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shops> removeShopsById(@PathVariable String id) {
        Shops deleteShops = shopService.removeShopsById(id);
        if (deleteShops != null) {
            return new ResponseEntity<>(deleteShops, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}