package com.example.mainexample.ui.view.recyclerview;

public class RecyclerDataItem {
    private Integer img;
    private String name, price;

    public RecyclerDataItem(Integer img, String name, String price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public Integer getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
