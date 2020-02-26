package com.example.spark.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;

public class movie_homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_homepage);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void insertMovies(){

    }

    public void goto_johnwick(View view) {
        Intent intent = new Intent(movie_homepage.this, johnwick.class);
        startActivity(intent);
    }

    public void goto_captainmarvel(View view) {
        Intent intent = new Intent(movie_homepage.this, captainmarvel.class);
        startActivity(intent);
    }

    public void goto_aquaman(View view) {
        Intent intent = new Intent(movie_homepage.this, aquaman.class);
        startActivity(intent);
    }

    public void goto_godzilla(View view) {
        Intent intent = new Intent(movie_homepage.this, godzilla.class);
        startActivity(intent);
    }
}
