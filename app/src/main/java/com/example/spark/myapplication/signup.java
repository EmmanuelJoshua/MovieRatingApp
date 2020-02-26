package com.example.spark.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import database.MoviesContract;
import database.MoviesRatingDbHelper;

public class signup extends AppCompatActivity {

    EditText userfield, emailfield, passfield, conpassword_field;

    CheckBox rememb;


    private MoviesRatingDbHelper mDbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mDbhelper = new MoviesRatingDbHelper(this);
    }

    public boolean validateInput(String user, String email, String pass, boolean remember) {
        if (user.equals("") && email.equals("") && pass.equals("") && remember == false) {
            Toast.makeText(signup.this, "All Fields are Empty", Toast.LENGTH_SHORT).show();
            return false;
        } else if (user.equals("") || email.equals("") || pass.equals("") || remember == false) {
            Toast.makeText(signup.this, "One or more fields are empty", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    public boolean validatePassword() {
        conpassword_field = findViewById(R.id.conpassword_field);
        String conPass = conpassword_field.getText().toString();
        passfield = findViewById(R.id.password_field);
        String pass = passfield.getText().toString();
        if (!pass.equals(conPass)) {
            Toast.makeText(signup.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    public void register(View view) {

        rememb = findViewById(R.id.checkBox);

        boolean rememberCheck = rememb.isChecked();

        userfield = findViewById(R.id.username_field);

        emailfield = findViewById(R.id.email_field);

        passfield = findViewById(R.id.password_field);

        String user = userfield.getText().toString().trim();

        String email = emailfield.getText().toString().trim();

        String pass = passfield.getText().toString().trim();

        SQLiteDatabase db = mDbhelper.getWritableDatabase();

        long ins = 0;

        if (validateInput(user,email,pass,rememberCheck) == true && validatePassword() == true) {
            ContentValues values = new ContentValues();
            values.put(MoviesContract.MoviesEntry.COLUMN_NAME_EMAIL, email);
            values.put(MoviesContract.MoviesEntry.COLUMN_NAME_USERNAME, user);
            values.put(MoviesContract.MoviesEntry.COLUMN_NAME_PASSWORD, pass);

            ins = db.insert(MoviesContract.MoviesEntry.TABLE_NAME, null, values);

            if (ins == -1) {
                Toast.makeText(signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
            } else if (ins >= 0) {
                Toast.makeText(signup.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }
        } else if (validateInput(user,email,pass,rememberCheck) == false && validatePassword() == false) {

        }
    }

}
