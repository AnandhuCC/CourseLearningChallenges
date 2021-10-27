package com.project.CourseLearningChallenges.Challenge5;

public class Item {

    private Long ID;
    private String name;
    private Double price;

    public Item(Long ID, String name, Double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
