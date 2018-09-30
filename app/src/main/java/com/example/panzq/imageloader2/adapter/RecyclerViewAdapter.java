package com.example.panzq.imageloader2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.panzq.imageloader2.R;
import com.example.panzq.imageloader2.RecyclerImageLoaderActivity;
import com.example.panzq.imageloader2.holder.RecyclerViewHolder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    //声明上下文引用，用于加载布局文件
    private Context mContext;
    private List<Integer> heights;

    //声明一个lmageloader引用
    private ImageLoader loader;

    //声明image的设置属性引用
    private DisplayImageOptions dios;
    private String[] ImageURL;
    public RecyclerViewAdapter(Context context, String[] imageurl, List<Integer> heighs) {
        this.mContext = context;
        this.ImageURL = imageurl;
        this.heights = heighs;
        //用imagerloader中静态方法创建对象
        loader = ImageLoader.getInstance();
        initImageOptions();
    }

    //通过构造方法传入加载布局文件得到的view对象
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RecyclerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i) {
//通过itemview得到每个图片的pararms对象
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) recyclerViewHolder.itemView.getLayoutParams();

        //将高度修改为传入的随机高度
        params.height = heights.get(i);

        //设置修改参数
        recyclerViewHolder.itemView.setLayoutParams(params);

        //通过loader对象的displayImage方法将网址中下载的图片按照设置的图片配置显示再imageview中
        loader.displayImage(ImageURL[i],recyclerViewHolder.imageView,dios);

    }

    @Override
    public int getItemCount() {
        return ImageURL.length;
    }

    private void initImageOptions()
    {
        dios = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.ic_robot)
                .showImageForEmptyUri(R.drawable.ic_robot)
                .showImageOnFail(R.drawable.ic_robot)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .displayer(new RoundedBitmapDisplayer(20))
                .build();
    }
}
