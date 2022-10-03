package com.example.mymemorybox;

public class Memory {
    private int rating, imageResourceId;
    private String name, desc;

    public Memory(int rating, int imageResourceId, String name, String desc) {
        this.rating = rating;
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.desc = desc;
    }

    public Memory(int rating, String name, String desc) {
        this.rating = rating;
        this.imageResourceId = 0;
        this.name = name;
        this.desc = desc;
    }

    public Memory() {
        this.rating = 0;
        this.imageResourceId = 0;
        this.name = "";
        this.desc = "";
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
