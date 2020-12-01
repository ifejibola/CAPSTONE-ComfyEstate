package com.example.comfy.Classifieds;

public class classifieds_obj {


    private String title;
    private String description;
    private int itemImage;

    public classifieds_obj(String title, String description, int itemImage) {
        this.title = title;
        this.description = description;
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


}
