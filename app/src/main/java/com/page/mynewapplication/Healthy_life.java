package com.page.mynewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import static java.security.AccessController.getContext;

public class Healthy_life extends AppCompatActivity {
     //ArrayList<HealthModel> healthdata;
    ArrayList<HealthModel> healthdata = new ArrayList<>();
    HealthyLifeAdapter adapter;
    RecyclerView recyclerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_life);
        addhealthdata();
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        HealthyLifeAdapter adapter = new HealthyLifeAdapter(Healthy_life.this, healthdata);
        recyclerView.setAdapter(adapter);
        // recyclerView.setHasFixedSize(true);
//            try {
//                if(healthdata != null && !healthdata.isEmpty()){
//                    adapter = new HealthyLifeAdapter(getApplicationContext(),healthdata);
//                    recyclerView.setAdapter(adapter);
//                }else{
//                   // healthdata = new ArrayList<HealthModel>();
//                    healthdata = new ArrayList<HealthModel>();
//                    for (int i = 0; i<MyData.nameArray.length; i++){
//                        healthdata.add(new HealthModel(
//                                MyData.nameArray[i],
//                                MyData.versionArray[i]
//                               // MyData.drawableArray[i]
//                        ));
//                    }
//                }
//            }catch (Exception e){}
    }

    public void addhealthdata(){

        HealthModel movie = new HealthModel("Top 7 cancer causing food", "A lysosome is a membrane-bound cell organelle that contains digestive enzymes. Lysosomes are involved with various cell processes.");
        healthdata.add(movie);


//        String[] images =context.getAssets().list("images");
//        ArrayList<String> listimages = new ArrayList<String>(Arrays.asList(images));
//        //listimages.add(listimages);


//        healthdata = new ArrayList<HealthModel>();
//        for (int i = 0; i<MyData.nameArray.length; i++){
//            healthdata.add(new HealthModel(
//                    MyData.nameArray[i],
//                    MyData.versionArray[i]
//                   // MyData.drawableArray[i]
//            ));
//        }

        movie = new HealthModel("Top 7 cancer causing food", "A lysosome is a membrane-bound cell organelle that contains digestive enzymes. Lysosomes are involved with various cell processes.");
        healthdata.add(movie);
        movie = new HealthModel("Top 7 cancer causing food", "A lysosome is a membrane-bound cell organelle that contains digestive enzymes. Lysosomes are involved with various cell processes.");
        healthdata.add(movie);
        movie = new HealthModel("Top 7 cancer causing food", "A lysosome is a membrane-bound cell organelle that contains digestive enzymes. Lysosomes are involved with various cell processes.");
        healthdata.add(movie);
        movie = new HealthModel("Top 7 cancer causing food", "A lysosome is a membrane-bound cell organelle that contains digestive enzymes. Lysosomes are involved with various cell processes.");
        healthdata.add(movie);
        movie = new HealthModel("Top 7 cancer causing food", "A lysosome is a membrane-bound cell organelle that contains digestive enzymes. Lysosomes are involved with various cell processes.");
        healthdata.add(movie);
        movie = new HealthModel("Top 7 cancer causing food", "A lysosome is a membrane-bound cell organelle that contains digestive enzymes. Lysosomes are involved with various cell processes.");
        healthdata.add(movie);
        movie = new HealthModel("Top 7 cancer causing food", "A lysosome is a membrane-bound cell organelle that contains digestive enzymes. Lysosomes are involved with various cell processes.");
        healthdata.add(movie);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }
}