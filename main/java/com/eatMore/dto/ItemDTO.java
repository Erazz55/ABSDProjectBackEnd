package com.eatMore.dto;

public class ItemDTO {

    private String itemName;
    private String itemPrice;
    private Integer shopId;

    public ItemDTO() {
    }

    public ItemDTO(String itemName, String itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public ItemDTO(String itemName, String itemPrice, Integer shopId) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.shopId = shopId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}
