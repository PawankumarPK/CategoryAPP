package com.company.retrofit_array_objects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.company.retrofit_array_objects.model.Feed;
import com.company.retrofit_array_objects.model.children.Children;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final String BASE_URL = "https://www.reddit.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RedditAPI redditAPI = retrofit.create(RedditAPI.class);
        Call<Feed> call = redditAPI.getData();

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());

                ArrayList<Children> childrenList = response.body().getData().getChildren();
                for (int i = 0; i < childrenList.size(); i++) {
                    Log.d(TAG, "onResponse: \n" +
                            "kind: " + childrenList.get(i).getKind() + "\n" +
                            "contest_mode: " + childrenList.get(i).getData().getContest_mode() + "\n" +
                            "subreddit: " + childrenList.get(i).getData().getSubreddit() + "\n" +
                            "author: " + childrenList.get(i).getData().getAuthor() + "\n" +
                            "-------------------------------------------------------------------------\n\n");
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/*

    public void onResponse(Call<Feed> call, Response<Feed> response) {
        Log.d(TAG,"onResponse : Server Response"+ response.toString());
        Log.d(TAG,"onResponse : Received Information"+ response.toString());

        // ArrayList<Children> childrenList = response.body().getData().getChildren();

        Log.d(TAG,"AFTER :" + response.body().getData().getAfter().toString());
        first.setText(response.body().getData().getAfter().toString());

        Log.d(TAG,"DIST :" + response.body().getData().getDist().toString());
        second.setText(response.body().getData().getDist().toString());

        Log.d(TAG,"WHISHLIST :" + response.body().getData().getWhitelist_status().toString());
        third.setText(response.body().getData().getWhitelist_status().toString());

*/

