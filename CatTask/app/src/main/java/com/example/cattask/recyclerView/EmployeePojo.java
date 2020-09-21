package com.example.cattask.recyclerView;

public class EmployeePojo {
    private String name;
    private String describtion;
    private int image;

    public EmployeePojo(String name, String describtion, int image){
        this.name = name;
        this.describtion = describtion;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
