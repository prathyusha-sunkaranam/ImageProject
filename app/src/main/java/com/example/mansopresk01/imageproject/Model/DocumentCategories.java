package com.example.mansopresk01.imageproject.Model;

import java.util.List;

/**
 * Created by Mansopresk01 on 10/30/2017.
 */

public class DocumentCategories {

    public String cat_id;
    public String cat_name;
    public String cat_icon;
    public String cat_background_img;
    public Integer num_docs;

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_icon() {
        return cat_icon;
    }

    public void setCat_icon(String cat_icon) {
        this.cat_icon = cat_icon;
    }

    public String getCat_background_img() {
        return cat_background_img;
    }

    public void setCat_background_img(String cat_background_img) {
        this.cat_background_img = cat_background_img;
    }

    public Integer getNum_docs() {
        return num_docs;
    }

    public void setNum_docs(Integer num_docs) {
        this.num_docs = num_docs;
    }
}
