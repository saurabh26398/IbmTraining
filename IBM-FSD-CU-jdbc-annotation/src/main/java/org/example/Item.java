package org.example;

import lombok.*;
import org.springframework.stereotype.Component;




@Component
public class Item {
    private String itemID;
    private String itemName;
    private int price;

    public Item() {
    }

    public Item(String itemID, String itemName, int price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
    }


    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
