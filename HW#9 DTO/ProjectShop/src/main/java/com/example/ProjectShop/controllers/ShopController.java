package com.example.ProjectShop.controllers;

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
    private ObjectMapper objectMapper;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/")
    public ResponseEntity<ShopsDto> addNewShop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        ShopsDto shopDto = objectMapper.readValue(requestBody, ShopsDto.class);
        Shops shops = modelMapper.map(shopDto, Shops.class);
        Shops newShop = shopService.addNewShops(new ShopsDto());
        ShopsDto newShopDto = modelMapper.map(newShop, ShopsDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(newShopDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<ShopsDto>> findAllShops() {
        List<ShopsDto> shopsDtoList = shopService.findAllShops();
        return ResponseEntity.ok().body(shopsDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopsDto> getShopById(@PathVariable Long id) {
        Optional<ShopsDto> shopDto = shopService.getShopsById(id)
                .map(shop -> modelMapper.map(shop, ShopsDto.class));
        if (shopDto.isPresent()) {
            return ResponseEntity.ok().body(shopDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopsDto> replaceShopById(@PathVariable Long id, HttpServletRequest request,
                                                    HttpServletResponse response) throws IOException {
        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        ShopsDto shopDto = objectMapper.readValue(requestBody, ShopsDto.class);
        Optional<ShopsDto> updatedShopDto = shopService.replaceShopsById(id, shopDto);
        if (updatedShopDto.isPresent()) {
            return ResponseEntity.ok().body(updatedShopDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> removeShopById(@PathVariable Long id) {
        shopService.removeShopsById(id);
        return ResponseEntity.noContent().build();
    }
}