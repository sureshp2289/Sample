package sample.example.com.sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import sample.example.com.sample.R;

/**
 * Created by Start4me on 6/9/2017.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.MyViewHolder> {
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_history;


        public MyViewHolder(View rowView) {
            super(rowView);




        }
    }

    public VideosAdapter(Context context) {


        this.context = context;


    }


    @Override
    public VideosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_videos, parent, false);

        return new VideosAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final VideosAdapter.MyViewHolder holder, final int position) {



    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

}

