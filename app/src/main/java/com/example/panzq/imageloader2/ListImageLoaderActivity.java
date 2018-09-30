package com.example.panzq.imageloader2;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.panzq.imageloader2.adapter.ListViewAdapter;
import com.example.panzq.imageloader2.databinding.ListImageActivityBinding;
import com.example.panzq.imageloader2.utils.Constants;
import com.example.panzq.imageloader2.utils.ImageURLUtils;

public class ListImageLoaderActivity extends Activity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener{
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListImageActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.list_image_activity);
        Log.d("panzqww","========ListImageLoaderActivity");
        listView = findViewById(R.id.lv_imageloader);
        listView.setAdapter(new ListViewAdapter(this, Constants.LISTVIEW));
        listView.setOnItemSelectedListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("panzqww","clicked --- "+ ImageURLUtils.IMAGEURL[i]);
    }
}
