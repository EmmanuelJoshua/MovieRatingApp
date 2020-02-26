package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import database.MoviesContract.MoviesEntry;

public class MoviesRatingDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MoviesRater.db";
    SQLiteDatabase db = this.getWritableDatabase();

    public MoviesRatingDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + MoviesEntry.TABLE_NAME + " ("
                + MoviesEntry.COLUMN_NAME_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MoviesEntry.COLUMN_NAME_EMAIL + " TEXT NOT NULL, "
                + MoviesEntry.COLUMN_NAME_USERNAME + " TEXT NOT NULL, "
                + MoviesEntry.COLUMN_NAME_PASSWORD + " TEXT NOT NULL)";

        String SQL_CREATE_RATING_TABLE = "CREATE TABLE " + MoviesEntry.MOVIERATING_TABLE_NAME + " ("
                + MoviesEntry.COLUMN_NAME_RATINGID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MoviesEntry.COLUMN_NAME_USERID + " INTEGER NOT NULL, "
                + MoviesEntry.COLUMN_NAME_MOVIENAME + " TEXT NOT NULL, "
                + MoviesEntry.COLUMN_NAME_RATINGREVIEW + " TEXT NOT NULL, "
                + MoviesEntry.COLUMN_NAME_RATING + " TEXT NOT NULL)";

        db.execSQL(SQL_CREATE_USER_TABLE);
        db.execSQL(SQL_CREATE_RATING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
