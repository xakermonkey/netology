package com.grin.poligon.ustils.models;

import java.util.List;

public class Model_of_many_coorces {
    String name;
    List<Model_of_cource>model_of_courceList;
    String image;

    public Model_of_many_coorces() {
    }

    public Model_of_many_coorces(String name, List<Model_of_cource> model_of_courceList, String image) {
        this.name = name;
        this.model_of_courceList = model_of_courceList;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model_of_cource> getModel_of_courceList() {
        return model_of_courceList;
    }

    public void setModel_of_courceList(List<Model_of_cource> model_of_courceList) {
        this.model_of_courceList = model_of_courceList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
