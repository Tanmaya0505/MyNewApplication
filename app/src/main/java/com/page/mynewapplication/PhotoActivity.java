package com.page.mynewapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.jsibbold.zoomage.ZoomageView;

import java.util.ArrayList;

public class PhotoActivity extends AppCompatActivity implements ImageDetailsAdapter.OnItemClickListener{
    GridView   simpleGrid;
    ArrayList<String> listPath;
    int[] logos = {R.drawable.ic_user_default, R.drawable.ic_user_default, R.drawable.ic_user_default, R.drawable.ic_user_default,
            R.drawable.ic_user_default, R.drawable.ic_user_default, R.drawable.ic_user_default, R.drawable.ic_user_default, R.drawable.ic_user_default,
            R.drawable.ic_user_default, R.drawable.ic_user_default, R.drawable.ic_user_default, R.drawable.ic_user_default};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        simpleGrid = (GridView) findViewById(R.id.imageGridView); // init GridView
        ImageDetailsAdapter imageDetailsAdapter =new ImageDetailsAdapter(getApplicationContext(),logos,this);
        simpleGrid.setAdapter(imageDetailsAdapter);

    }

    @Override
    public void onItemClick(Drawable drawable) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.activity_single_view, null);
        LayoutInflater mInflater = LayoutInflater.from(this);
        ZoomageView photoView = mView.findViewById(R.id.imageViewZoom);

        mBuilder.setView(mView);
        photoView.setImageDrawable(drawable);
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }
}