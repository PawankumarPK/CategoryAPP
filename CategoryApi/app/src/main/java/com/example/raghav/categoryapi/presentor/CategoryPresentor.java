package com.example.raghav.categoryapi.presentor;

import android.content.Context;

import com.example.raghav.categoryapi.model.CategoryModel;
import com.example.raghav.categoryapi.pojoclass.CategoryDataJsonBean;
import com.example.raghav.categoryapi.view.CategoryView;

import java.util.List;

/**
 * Created by Raghav on 1/10/2018.
 */

public class CategoryPresentor implements CategoryPresentorInterface, CategoryModel.CategoryModelInterfaceCallback {

    private Context context;
    private CategoryModel categoryModel;
    private CategoryView categoryView;

    public CategoryPresentor(Context context,CategoryView categoryView)
    {
        this.context=context;
        this.categoryView=categoryView;
        this.categoryModel=new CategoryModel();
    }
    @Override
    public void getCategory() {
        if (categoryModel!=null)
        {
            categoryModel.getCategories(this);
        }

    }

    @Override
    public void onSuccess(List<CategoryDataJsonBean> categoryDataJsonBean) {
        if(categoryView!=null)
        {
            categoryView.onSuccess(categoryDataJsonBean);
        }

    }

    @Override
    public void onError(String error) {
        if(categoryView!=null)
        {
            categoryView.onError(error);
        }

    }
}
