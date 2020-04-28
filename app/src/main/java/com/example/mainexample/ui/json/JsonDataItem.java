package com.example.mainexample.ui.json;

public class JsonDataItem {
    private String hinh, ten, gia;

    public JsonDataItem(String hinh, String ten, String gia) {
        this.hinh = hinh;
        this.ten = ten;
        this.gia = gia;
    }

    public String getHinh() {
        return hinh;
    }

    public String getTen() {
        return ten;
    }

    public String getGia() {
        return gia;
    }
}
