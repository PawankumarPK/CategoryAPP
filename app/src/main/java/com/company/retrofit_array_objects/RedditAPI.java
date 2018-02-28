package com.company.retrofit_array_objects;

import com.company.retrofit_array_objects.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RedditAPI {

    String BASE_URL = "https://www.reddit.com/";

    //HEllooooooo
//hjhgjh
    //Yafgdhjofg
    //fgnfgf

    String url = "";

    @Headers("Content-Type: application/json")
    @GET(".json")
    Call<Feed> getData();

}