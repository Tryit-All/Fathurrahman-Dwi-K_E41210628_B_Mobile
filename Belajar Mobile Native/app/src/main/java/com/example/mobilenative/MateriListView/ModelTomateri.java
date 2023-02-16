package com.example.mobilenative.MateriListView;

public class ModelTomateri {

    String name;
    String message;
    int img;
    String feature;

    public ModelTomateri(String name, String message, int img) {
        this.name=name;
        this.message=message;
        this.img=img;
        this.feature=feature;

    }

    public String getNames() {
        return name;
    }

    public String getMessages() {
        return message;
    }

    public int getImgs() {
        return img;
    }

    public String getFeatures() {
        return feature;
    }

}
