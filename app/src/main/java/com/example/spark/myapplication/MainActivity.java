package com.example.spark.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import database.MoviesContract.MoviesEntry;
import database.MoviesRatingDbHelper;

public class MainActivity extends AppCompatActivity {

    private MoviesRatingDbHelper mDbhelper;

    public int dbuserID;

    public static int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbhelper = new MoviesRatingDbHelper(this);
    }


    public boolean validateLogin(String username, String password) {
        SQLiteDatabase db = mDbhelper.getReadableDatabase();

        String[] projection = {
                MoviesEntry.COLUMN_NAME_USERID,
                MoviesEntry.COLUMN_NAME_USERNAME,
                MoviesEntry.COLUMN_NAME_PASSWORD
        };

        String selection = MoviesEntry.COLUMN_NAME_USERNAME + "=?" + " AND " +MoviesEntry.COLUMN_NAME_PASSWORD + " =?";

        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(
                MoviesEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        int userIDColumnIndex = cursor.getColumnIndex(MoviesEntry.COLUMN_NAME_USERID);
        int userColumnIndex = cursor.getColumnIndex(MoviesEntry.COLUMN_NAME_USERNAME);
        int passColumnIndex = cursor.getColumnIndex(MoviesEntry.COLUMN_NAME_PASSWORD);
        boolean flag = false;
        try {
            while (cursor.moveToNext()) {
                String dbuser = cursor.getString(userColumnIndex);
                String dbpass = cursor.getString(passColumnIndex);

                if (!username.equals(dbuser) || !password.equals(dbpass)) {
                    flag = false;
                } else if (username.equals(dbuser) || password.equals(dbpass)) {
                    dbuserID = cursor.getInt(userIDColumnIndex);
                    flag = true;
                }
            }
        } finally {
            cursor.close();
            db.close();
        }
        return flag;
    }

    public void login(View view) {
        EditText userField = findViewById(R.id.user_field);

        EditText passField = findViewById(R.id.pass_field);

        String user = userField.getText().toString().trim();

        String pass = passField.getText().toString().trim();

        if (validateLogin(user, pass)) {
            userID = dbuserID;
            Log.i("@RatingsApp: ","User ID - "+dbuserID);
            Intent intent = new Intent(MainActivity.this, movie_homepage.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }

    }

    public void register(View view) {
        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);
    }

    public void gotoFacebook(View view) {

    }

    public void gotoTwitter(View view) {

    }

    public void gotoInstagram(View view) {

    }


}
