package com.example.mobilenative;

public class Model {

    String name;
    String message;
    int img;
    String feature;

    public Model(String name, String message, int img) {
        this.name=name;
        this.message=message;
        this.img=img;
        this.feature=feature;

    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getImg() {
        return img;
    }

    public String getFeature() {
        return feature;
    }

}
