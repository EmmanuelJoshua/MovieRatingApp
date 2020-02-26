package com.example.spark.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import database.MoviesContract;
import database.MoviesRatingDbHelper;

public class johnwick extends AppCompatActivity {

    EditText review;

    RatingBar rating;

    MoviesRatingDbHelper mDbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_johnwick);

        mDbhelper = new MoviesRatingDbHelper(this);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public boolean validateReviews(String reviews,float ratings){
        if(reviews.equals("") && ratings == 0){
            Toast.makeText(johnwick.this, "Enter a review", Toast.LENGTH_SHORT).show();
            return false;
        }else if(reviews.equals("") || ratings == 0){
            Toast.makeText(johnwick.this, "Check the fields", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }

    }

    public void submitReview(View view){
        String moviename = "John Wick 3 : Parabellum.";

        int userID = MainActivity.userID;

        review = findViewById(R.id.johnwick_review);

        rating = findViewById(R.id.johnwick_rating);

        String review1 = review.getText().toString().trim();

        float rating1 = rating.getRating();

        SQLiteDatabase db = mDbhelper.getWritableDatabase();

        if(validateReviews(review1,rating1) == true){
            ContentValues values = new ContentValues();
            values.put(MoviesContract.MoviesEntry.COLUMN_NAME_USERID,userID);
            values.put(MoviesContract.MoviesEntry.COLUMN_NAME_MOVIENAME,moviename);
            values.put(MoviesContract.MoviesEntry.COLUMN_NAME_RATINGREVIEW ,review1);
            values.put(MoviesContract.MoviesEntry.COLUMN_NAME_RATING, rating1);

            long ins = db.insert(MoviesContract.MoviesEntry.MOVIERATING_TABLE_NAME,null,values);

            if(ins == -1){
                Toast.makeText(johnwick.this, "Submission Failed", Toast.LENGTH_SHORT).show();
            }else if(ins >= 0){
                Toast.makeText(johnwick.this, "Submission Successful", Toast.LENGTH_SHORT).show();
            }
        }else if(validateReviews(review1,rating1) == false){

        }
    }
}
