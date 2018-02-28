package com.example.raghav.categoryapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.raghav.categoryapi.pojoclass.CategoryDataJsonBean;
import com.example.raghav.categoryapi.presentor.CategoryPresentor;
import com.example.raghav.categoryapi.presentor.CategoryPresentorInterface;
import com.example.raghav.categoryapi.view.CategoryView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoryView{
    public CategoryPresentorInterface categoryPresentorInterface;
    public RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<CategoryDataJsonBean> categoryDataJsonBeanList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter=new RecyclerViewAdapter(this,categoryDataJsonBeanList);
        recyclerView.setAdapter(recyclerViewAdapter);
        categoryPresentorInterface=new CategoryPresentor(this,this);
        categoryPresentorInterface.getCategory();
    }

    @Override
    public void onSuccess(List<CategoryDataJsonBean> categoryDataJsonBeans) {
        categoryDataJsonBeanList.addAll(categoryDataJsonBeans);
        recyclerViewAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
        GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if(child != null && gestureDetector.onTouchEvent(e)) {
                int position = rv.getChildAdapterPosition(child);
                //Toast.makeText(getApplicationContext(), countries.get(position), Toast.LENGTH_SHORT).show();
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    });
}
}
