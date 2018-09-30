package com.example.panzq.imageloader2.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.panzq.imageloader2.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }
}
