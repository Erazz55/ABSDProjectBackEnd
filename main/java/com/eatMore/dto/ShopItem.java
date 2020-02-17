package com.eatMore.dto;

public class ShopItem {

    private String itemName;
    private String itemPrice;

    public ShopItem() {
    }

    public ShopItem(String itemName, String itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
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



    @Override
    public String toString() {
        return "ShopItem{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                '}';
    }
}
