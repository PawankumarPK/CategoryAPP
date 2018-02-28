package com.example.raghav.categoryapi.pojoclass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Raghav on 1/10/2018.
 */

public class CategoryPojo {
    @SerializedName("categories")
    private List<CategoryDataJsonBean> categories = null;
    @SerializedName("status")
    private Integer status;

    public List<CategoryDataJsonBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDataJsonBean> categories) {
        this.categories = categories;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}