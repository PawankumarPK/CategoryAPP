package com.example.raghav.categoryapi.pojoclass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Raghav on 1/10/2018.
 */

public class CategoryDataJsonBean {
    @SerializedName("category_id")
    private Integer categoryId;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("category_description")
    private String categoryDescription;
    @SerializedName("featured")
    private String featured;
    @SerializedName("status")
    private String status;
    @SerializedName("slug_name")
    private String slugName;
    @SerializedName("cat_img_path")
    private Object catImgPath;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSlugName() {
        return slugName;
    }

    public void setSlugName(String slugName) {
        this.slugName = slugName;
    }

    public Object getCatImgPath() {
        return catImgPath;
    }

    public void setCatImgPath(Object catImgPath) {
        this.catImgPath = catImgPath;
    }

}
