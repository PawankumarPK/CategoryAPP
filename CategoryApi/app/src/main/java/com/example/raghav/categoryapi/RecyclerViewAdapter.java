package com.example.raghav.categoryapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raghav.categoryapi.pojoclass.CategoryDataJsonBean;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass>{
    private Context context;
    private List<CategoryDataJsonBean> categoryDataJsonBeans;

    public RecyclerViewAdapter(MainActivity mainActivity, List<CategoryDataJsonBean> categoryDataJsonBeans) {
        this.context = mainActivity;
        this.categoryDataJsonBeans = categoryDataJsonBeans;
    }


    @Override
    public RecyclerViewAdapter.ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
        return new ViewHolderClass(itemView);
    }



    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolderClass holder, int position) {
        holder.name.setText(categoryDataJsonBeans.get(position).getCategoryName());
        //holder.realname.setText("Slug Name" + categoryDataJsonBeans.get(position).getSlugName());
       // holder.name.setText(categoryDataJsonBeans.get(position).);
    }

    @Override
    public int getItemCount() {
        return categoryDataJsonBeans.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        private TextView name, realname;

        public ViewHolderClass(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.id);
            //realname = itemView.findViewById(R.id.realname);
        }
    }
}
