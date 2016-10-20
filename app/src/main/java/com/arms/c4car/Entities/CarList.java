package com.arms.c4car.Entities;

/**
 * Created by SHIVAA on 16-10-2016.
 */

public class CarList {

    private int id;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarList(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
