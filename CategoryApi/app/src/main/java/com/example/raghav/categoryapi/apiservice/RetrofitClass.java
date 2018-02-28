package com.example.raghav.categoryapi.apiservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raghav on 1/4/2018.
 */

public class RetrofitClass {

    public static Retrofit retrofit=null;

    public static Retrofit getClent(){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl("http://54.83.64.203//api/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
