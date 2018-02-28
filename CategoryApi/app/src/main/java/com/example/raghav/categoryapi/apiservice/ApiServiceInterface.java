package com.example.raghav.categoryapi.apiservice;

import com.example.raghav.categoryapi.pojoclass.CategoryPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Raghav on 1/4/2018.
 */

public interface ApiServiceInterface {

    @GET("categories")
    Call<CategoryPojo> getcategory();
}
