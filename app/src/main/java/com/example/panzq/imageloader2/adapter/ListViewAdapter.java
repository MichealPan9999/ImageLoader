package com.example.panzq.imageloader2.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.panzq.imageloader2.R;
import com.example.panzq.imageloader2.utils.Constants;
import com.example.panzq.imageloader2.utils.ImageURLUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private int ListOrGrid;
    DisplayImageOptions options;
    String[] imageUrls = ImageURLUtils.IMAGEURL;
    private ImageLoader imageLoader ;
    private ImageLoadingListener animateFirstListener;

    public ListViewAdapter(Context mContext,int ListOrGrid) {
        this.mContext = mContext;
        this.ListOrGrid = ListOrGrid;
        initImageOptions();
        imageLoader = ImageLoader.getInstance();
        animateFirstListener = new AnimateFirstDisplayListener();
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            if (ListOrGrid == Constants.LISTVIEW) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,
                        viewGroup, false);
            }else{
                convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item,
                        viewGroup, false);
            }
            viewHolder = new ViewHolder();
            viewHolder.text = convertView.findViewById(R.id.text);
            viewHolder.image = convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.text.setText("Item"+(i+1));
        imageLoader.displayImage(imageUrls[i],viewHolder.image,options,animateFirstListener);

        return convertView;
    }

    private class ViewHolder {
        public TextView text;
        public ImageView image;
    }

    private void initImageOptions()
    {
        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.ic_robot)
                .showImageForEmptyUri(R.drawable.ic_robot)
                .showImageOnFail(R.drawable.ic_robot)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .displayer(new RoundedBitmapDisplayer(20))
                .build();
    }


    private class AnimateFirstDisplayListener extends SimpleImageLoadingListener {
        final List<String> displayedImages = Collections
                .synchronizedList(new LinkedList<String>());
        @Override
        public void onLoadingStarted(String s, View view) {

        }

        @Override
        public void onLoadingFailed(String s, View view, FailReason failReason) {

        }

        @Override
        public void onLoadingComplete(String imageurl, View view, Bitmap bitmap) {

            if (bitmap != null)
            {
                ImageView imageview = (ImageView)view;
                boolean firstDisplay = !displayedImages.contains(imageurl);
                if (firstDisplay)
                {
                    FadeInBitmapDisplayer.animate(imageview,500);
                    displayedImages.add(imageurl);
                }
            }
        }

        @Override
        public void onLoadingCancelled(String s, View view) {

        }
    }
}
