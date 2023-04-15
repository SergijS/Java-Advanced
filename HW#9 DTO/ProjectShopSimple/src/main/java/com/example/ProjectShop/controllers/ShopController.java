package com.example.ProjectShop.controllers;

import com.example.ProjectShop.dto.ShopsDto;
import com.example.ProjectShop.service.shopServiceImpl.ShopServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;


@AllArgsConstructor
@RestController
@RequestMapping("/api/shops")

public class ShopController extends HttpServlet {
    private final ShopServiceImpl shopService;
    private final ObjectMapper objectMapper;

    @PostMapping
    public void addNewShops(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            BufferedReader reader = request.getReader();
            String shopJson = reader.lines().collect(Collectors.joining());
            ShopsDto shopDTO = objectMapper.readValue(shopJson, ShopsDto.class);
            shopService.addNewShops(shopDTO);
            response.setStatus(HttpStatus.CREATED.value());
            response.getWriter().write(shopJson);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public void getShopById(@PathVariable Long id, HttpServletResponse response) {
        try {
            ShopsDto shopDTOById = shopService.getShopById(id);
            response.setStatus(HttpStatus.OK.value());
            objectMapper.writeValueAsString(shopDTOById);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
    }
}