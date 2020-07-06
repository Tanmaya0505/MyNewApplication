package com.page.mynewapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HealthyLifeAdapter extends RecyclerView.Adapter<HealthyLifeAdapter.HealthyViewHolder> {
    ArrayList<HealthModel> healthModelList;
    private Context ctx;
    public HealthyLifeAdapter(Context context,ArrayList<HealthModel> healthModelList) {
        ctx = context;
        this.healthModelList = healthModelList;
    }
    @NonNull
    @Override
    public HealthyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_health_model,parent,false);

          HealthyViewHolder vh = new HealthyViewHolder(V);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull HealthyViewHolder holder, int position) {
        holder.selectHealth = healthModelList.get(position);
        holder.healthtextView.setText(holder.selectHealth.getHealthtitle());
        holder.descriptiontextView.setText(holder.selectHealth.getHealthdescription());
        //holder.healthimageView.setImageResource(holder.selectHealth.getHealthimage());
        try {

           // String[] imges = ctx.getAssets().list("images");
//            String[] images =ctx.getAssets().list("images");
//            ArrayList<String> listimages = new ArrayList<String>(Arrays.asList(images));
//            //InputStream inputStream= ctx.getAssets().open("images"+listimages.get(position));
//            Drawable drawable = Drawable.createFromStream(ctx.getAssets().open("images"+listimages.get(position)), null);
//           // Drawable drawable = Drawable.createFromStream(inputStream,null);
//            holder.healthimageView.setImageDrawable(drawable);

            String[] images =ctx.getAssets().list("images");
            ArrayList<String> listImages = new ArrayList<String>(Arrays.asList(images));
            InputStream inputstream=ctx.getAssets().open("images/"
                    +listImages.get(position));
            Drawable drawable = Drawable.createFromStream(inputstream, null);
            holder.healthimageView.setImageDrawable(drawable);

        }catch (Exception e){}

    }
    @Override
    public int getItemCount() {
        return healthModelList.size();
    }

    public class HealthyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.healthImage)
        ImageView healthimageView;
        @BindView(R.id.healthTitle)
        TextView healthtextView;
        @BindView(R.id.healthDescription)
        TextView descriptiontextView;
        public HealthModel selectHealth;
        public HealthyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            healthtextView = itemView.findViewById(R.id.healthTitle);
            descriptiontextView = itemView.findViewById(R.id.healthDescription);
        }
    }
}
