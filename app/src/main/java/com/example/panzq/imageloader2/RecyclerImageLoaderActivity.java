package com.example.panzq.imageloader2;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.panzq.imageloader2.databinding.ListImageActivityBinding;
import com.example.panzq.imageloader2.databinding.RecyclerImageActivityBinding;

public class RecyclerImageLoaderActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerImageActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.recycler_image_activity);
        Log.d("panzqww","========RecyclerImageLoaderActivity");
    }
}
