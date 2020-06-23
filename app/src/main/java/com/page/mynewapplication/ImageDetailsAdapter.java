package com.page.mynewapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class ImageDetailsAdapter extends BaseAdapter {

    private Context mContext;
    private OnItemClickListener listener;
   // LayoutInflater inflter;
    int[] logos;
    //private ArrayList<String> listPath;
   // int  listPath[];

    public ImageDetailsAdapter(Context context,int [] logos, OnItemClickListener listener){
        mContext = context;
        this.logos = logos;
        this.listener = listener;
        //inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        //return logos.length;
        return logos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //convertView = inflter.inflate(R.layout.activity_imagegridview, null);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_imagegridview, null);
        ImageView imageView;

        imageView = convertView.findViewById(R.id.ic_imageicon);
        imageView.setImageResource(logos[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    listener.onItemClick(mContext.getDrawable(logos[position]));
                }catch (Exception e){}

            }
        });
        return imageView;
    }
   public interface OnItemClickListener{
        void onItemClick(Drawable drawable);
    }

}
