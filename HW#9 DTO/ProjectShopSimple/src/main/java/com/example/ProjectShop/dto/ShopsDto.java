package com.example.ProjectShop.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopsDto {

    private Long id;
    private String city;
    private String street;
    private String houseNumber;
    private String shopName;
    private boolean hasOrNotSite;
}