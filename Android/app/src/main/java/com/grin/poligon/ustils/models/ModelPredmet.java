package com.grin.poligon.ustils.models;

public class ModelPredmet {

    private String name;
    private Integer color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ModelPredmet(String name, Integer color, String time) {
        this.name = name;
        this.color = color;
        this.time = time;
    }

    private String time;
    public ModelPredmet() {
    }


}
