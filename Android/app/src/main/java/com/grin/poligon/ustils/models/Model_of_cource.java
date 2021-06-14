package com.grin.poligon.ustils.models;

public class Model_of_cource {
    public Model_of_cource() {

    }

    int image_res;
    String name;

    public int getImage_res() {
        return image_res;
    }

    public void setImage_res(int image_res) {
        this.image_res = image_res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Model_of_cource(int image_res, String name) {
        this.image_res = image_res;
        this.name = name;
    }
}
