package com.example.comfy.Explore;

import com.example.comfy.R;

import java.util.ArrayList;
import java.util.List;

public class posts_obj {


    private String title;
    private String description;
    private String price;
    private int itemImage;


    public posts_obj(String title, String description, String price, int itemImage) {
        this.title = title;
        this.description = description;
        this.price=price;
        this.itemImage = itemImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getItemImage() {
        return itemImage;
    }

    public String getPrice() {
        return price;
    }
}
