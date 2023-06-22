package com.example.aplicacionlistas1.model.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
