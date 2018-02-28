package com.example.raghav.categoryapi.view;

import com.example.raghav.categoryapi.pojoclass.CategoryDataJsonBean;

import java.util.List;

/**
 * Created by Raghav on 1/10/2018.
 */

public interface CategoryView {
    void onSuccess(List<CategoryDataJsonBean> categoryDataJsonBeans);
    void onError(String error);
}
