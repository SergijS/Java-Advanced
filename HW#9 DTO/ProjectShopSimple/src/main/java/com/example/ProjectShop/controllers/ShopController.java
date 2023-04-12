package com.example.ProjectShop.controllers;
import com.example.ProjectShop.dto.ShopsDto;
import com.example.ProjectShop.service.shopServiceImpl.ShopServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Optional;
import java.io.IOException;
import java.util.stream.Collectors;


@AllArgsConstructor
@RestController
@RequestMapping("/api/shops")

public class ShopController extends HttpServlet {
    private final ShopServiceImpl shopService;
    private final ObjectMapper objectMapper;
@PostMapping
    public void addNewShop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        ShopsDto newShop = shopService.addNewShops(objectMapper.readValue(requestBody, ShopsDto.class));
        URI location = URI.create("/api/shops/" + newShop.getId());
        response.setHeader("Location", location.toString());
        response.setStatus(HttpServletResponse.SC_CREATED);
        response.getWriter().write(objectMapper.writeValueAsString(newShop));
    }
@GetMapping("/{id}")
    public void getShopById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Optional<ShopsDto> shopDto = shopService.getShopsById(id);
        if (shopDto.isPresent()) {
            response.getWriter().write(objectMapper.writeValueAsString(shopDto.get()));
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}