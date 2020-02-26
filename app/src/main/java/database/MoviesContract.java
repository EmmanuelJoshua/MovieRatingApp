package database;

import android.provider.BaseColumns;

public final class MoviesContract {
    private MoviesContract() {
    }

    public static class MoviesEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USERID = "userid";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_EMAIL = "email";

        public static final String MOVIE_TABLE_NAME = "movies";
        public static final String COLUMN_NAME_MOVIEID = "movieid";
        public static final String COLUMN_NAME_MOVIENAME = "moviename";
        public static final String COLUMN_NAME_MOVIEDESC = "moviedesc";
        public static final String COLUMN_NAME_MOVIEIMAGE = "movieimage";

        public static final String MOVIERATING_TABLE_NAME = "movierating";
        public static final String COLUMN_NAME_RATINGID = "ratingid";
        public static final String COLUMN_NAME_RATING = "rating";
        public static final String COLUMN_NAME_RATINGREVIEW = "ratingreview";
    }

}