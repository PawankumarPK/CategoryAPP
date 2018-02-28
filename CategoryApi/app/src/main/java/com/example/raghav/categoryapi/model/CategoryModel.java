package com.example.raghav.categoryapi.model;

import com.example.raghav.categoryapi.apiservice.ApiServiceInterface;
import com.example.raghav.categoryapi.apiservice.RetrofitClass;
import com.example.raghav.categoryapi.pojoclass.CategoryDataJsonBean;
import com.example.raghav.categoryapi.pojoclass.CategoryPojo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Raghav on 1/10/2018.
 */

interface CategoryModelInteface {
    interface CategoryModelInterfaceCallback {
        void onSuccess(List<CategoryDataJsonBean> categoryDataJsonBean);

        void onError(String error);
    }

    void getCategories(CategoryModelInterfaceCallback categoryModelInterfaceCallback);
}

public class CategoryModel implements CategoryModelInteface {
    @Override
    public void getCategories(final CategoryModelInterfaceCallback categoryModelInterfaceCallback) {
        ApiServiceInterface apiServiceInterface = RetrofitClass.getClent().create(ApiServiceInterface.class);
        Call<CategoryPojo> categoryDataBeanCall = apiServiceInterface.getcategory();
        categoryDataBeanCall.enqueue(new Callback<CategoryPojo>() {
            @Override
            public void onResponse(Call<CategoryPojo> call, Response<CategoryPojo> response) {
                if (response.code() == 200) {
                    categoryModelInterfaceCallback.onSuccess(response.body().getCategories());
                } else {
                    JSONObject jObjError = null;
                    try {
                        jObjError = new JSONObject(response.errorBody().string());
                        String error = jObjError.getString("");
                        String error1 = jObjError.getString("");
                        categoryModelInterfaceCallback.onError(error);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onFailure(Call<CategoryPojo> call, Throwable t) {
                categoryModelInterfaceCallback.onError(t.getMessage());

            }
        });
    }
}
