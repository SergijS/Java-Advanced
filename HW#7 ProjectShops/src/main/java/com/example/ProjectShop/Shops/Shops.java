package com.example.ProjectShop.Shops;

public class Shops {

    private String id;
    private String city;
    private String street;
    private String houseNumber;
    private String shopName;
    private int numberOfEmployees;
    private boolean hasOrNotSite;

    public Shops() {
    }

    public Shops(String id, String city, String street, String houseNumber, String shopName, int numberOfEmployees, boolean hasOrNotSite) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.shopName = shopName;
        this.numberOfEmployees = numberOfEmployees;
        this.hasOrNotSite = hasOrNotSite;
    }

    public Shops(String city, String street, String houseNumber, String shopName, int numberOfEmployees, boolean hasOrNotSite) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.shopName = shopName;
        this.numberOfEmployees = numberOfEmployees;
        this.hasOrNotSite = hasOrNotSite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public boolean isHasOrNotSite() {
        return hasOrNotSite;
    }

    public void setHasOrNotSite(boolean hasOrNotSite) {
        this.hasOrNotSite = hasOrNotSite;
    }
}