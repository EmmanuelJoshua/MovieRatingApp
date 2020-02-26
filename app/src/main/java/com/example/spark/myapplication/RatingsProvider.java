package com.example.spark.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import database.MoviesContract;
import database.MoviesRatingDbHelper;

public class RatingsProvider extends ContentProvider {

    private MoviesRatingDbHelper mDbhelper;

    public Cursor cursor;

    public static final String PROVIDER_NAME = "com.example.spark.myapplication.PROVIDER";

    private static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "users/", 1);
        uriMatcher.addURI(PROVIDER_NAME, "movierating/", 2);
    }

    public RatingsProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
       return mDbhelper.getWritableDatabase().delete(MoviesContract.MoviesEntry.MOVIERATING_TABLE_NAME,selection,selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        mDbhelper = new MoviesRatingDbHelper(this.getContext());

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        switch (uriMatcher.match(uri)){
            case 1:
                cursor = mDbhelper.getReadableDatabase().query(MoviesContract.MoviesEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case 2:
                cursor = mDbhelper.getReadableDatabase().query(MoviesContract.MoviesEntry.MOVIERATING_TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;

                default:
                    throw new IllegalArgumentException("Cannot query unknown uri " +uri);
        }
            return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
