package com.example.ProjectShop.controllers;

import com.example.ProjectShop.converter.ShopConverter;
import com.example.ProjectShop.dto.ShopsDto;
import com.example.ProjectShop.service.shopServiceImpl.ShopServiceImpl;
import com.example.ProjectShop.entity.Shops;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/shops")

public class ShopController {
    @Autowired
    private ShopServiceImpl shopService;
    @Autowired
    private ShopConverter shopConverter;
    @PostMapping
    public ResponseEntity<ShopsDto> addNewShop(@RequestBody ShopsDto shopsDto) {
        ShopsDto newShop = shopService.addNewShops(shopsDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newShop.getId())
                .toUri();
        return ResponseEntity.created(location).body(newShop);
    }

    @GetMapping("/")
    public ResponseEntity<List<ShopsDto>> findAllShops() {
        List<ShopsDto> shopsDtoList = shopService.findAllShops();
        return ResponseEntity.ok(shopsDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopsDto> getShopById(@PathVariable Long id) {
        Optional<ShopsDto> shopDto = shopService.getShopsById(id);
        return shopDto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopsDto> replaceShopById(@PathVariable Long id, @RequestBody ShopsDto shopsDto) {
        Optional<ShopsDto> replaceShopDto = shopService.replaceShopsById(id, shopsDto);
        return replaceShopDto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeShopById(@PathVariable Long id) {
        shopService.removeShopsById(id);
        return ResponseEntity.noContent().build();
    }
}