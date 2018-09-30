package com.example.panzq.imageloader2;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.example.panzq.imageloader2.adapter.RecyclerViewAdapter;
import com.example.panzq.imageloader2.databinding.ListImageActivityBinding;
import com.example.panzq.imageloader2.databinding.RecyclerImageActivityBinding;
import com.example.panzq.imageloader2.utils.Constants;
import com.example.panzq.imageloader2.utils.ImageURLUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerImageLoaderActivity extends Activity {
    private RecyclerView mRecyclerView;
    //声明自定义适配器
    private RecyclerViewAdapter adapter;
    //创建一个list集合存储recyclerview中的图片的高度
    private List<Integer> heighs = null;
    private String[] ImageURLs = ImageURLUtils.IMAGEURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerImageActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.recycler_image_activity);
        Log.d("panzqww", "========RecyclerImageLoaderActivity");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //设置recyclerview要实现的类型为StaggeredGrid瀑布流类型
        //并再构造方法中指定列数3，纵向排列
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL));
        initHeights();
        initAdapter();
    }

    //初始化适配器
    private void initAdapter() {

        //创建自定义适配器对象
        adapter = new RecyclerViewAdapter(this, ImageURLUtils.IMAGEURL, heighs);

        //设置recyclerview适配器
        mRecyclerView.setAdapter(adapter);

        //刷新适配器
        adapter.notifyDataSetChanged();
    }

    private void initHeights() {
        if (heighs == null) {
            heighs = new ArrayList<Integer>();
            for (int i = 0; i < ImageURLs.length; i++) {
                int height = (int) ((Math.random() * 70) + 100);
                heighs.add(height);
            }
        }
    }
}
