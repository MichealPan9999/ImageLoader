package com.example.panzq.imageloader2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.panzq.imageloader2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_list:
                        Log.d("panzqww", "onclick list");
                        intent = new Intent(MainActivity.this, ListImageLoaderActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btn_grid:
                        Log.d("panzqww", "onclick grid");
                        intent = new Intent(MainActivity.this, GridImageLoaderActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btn_recycler:
                        Log.d("panzqww", "onclick recycler");
                        intent = new Intent(MainActivity.this, RecyclerImageLoaderActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

}
