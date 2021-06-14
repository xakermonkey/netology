package com.grin.poligon.ustils.models;

import java.util.List;

public class ModelOfResultLearning {

    String name_of_result;
    String image_of_result;
    List<String> list_of_need_kurs;

    public ModelOfResultLearning(String name_of_result, String image_of_result, List<String> list_of_need_kurs) {
        this.name_of_result = name_of_result;
        this.image_of_result = image_of_result;
        this.list_of_need_kurs = list_of_need_kurs;
    }

    public ModelOfResultLearning() {
    }

    public String getName_of_result() {
        return name_of_result;
    }

    public void setName_of_result(String name_of_result) {
        this.name_of_result = name_of_result;
    }

    public String getImage_of_result() {
        return image_of_result;
    }

    public void setImage_of_result(String image_of_result) {
        this.image_of_result = image_of_result;
    }

    public List<String> getList_of_need_kurs() {
        return list_of_need_kurs;
    }

    public void setList_of_need_kurs(List<String> list_of_need_kurs) {
        this.list_of_need_kurs = list_of_need_kurs;
    }
}
