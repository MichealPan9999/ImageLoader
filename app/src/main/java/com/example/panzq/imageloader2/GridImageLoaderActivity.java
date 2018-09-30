package com.example.panzq.imageloader2;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.GridView;

import com.example.panzq.imageloader2.adapter.ListViewAdapter;
import com.example.panzq.imageloader2.databinding.GridImageActivityBinding;
import com.example.panzq.imageloader2.databinding.ListImageActivityBinding;
import com.example.panzq.imageloader2.utils.Constants;

public class GridImageLoaderActivity extends Activity{
    private GridView gridView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridImageActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.grid_image_activity);
        Log.d("panzqww","========GridImageActivityBinding");
        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ListViewAdapter(this, Constants.GRIDVIEW));
    }
}
