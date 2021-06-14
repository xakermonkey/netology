package com.grin.poligon.ustils.models;

public class Model_of_user {
    String name;
    String image;
    String id;
    String about;
    String count_of_point;


    public Model_of_user() {
    }

    public Model_of_user(String name, String image, String id, String about, String count_of_point) {
        this.name = name;
        this.image = image;
        this.id = id;
        this.about = about;
        this.count_of_point = count_of_point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCount_of_point() {
        return count_of_point;
    }

    public void setCount_of_point(String count_of_point) {
        this.count_of_point = count_of_point;
    }
}
