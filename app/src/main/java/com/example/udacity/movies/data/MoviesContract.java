package com.example.udacity.movies.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by justinmitchell on 7/11/2016.
 */

public class MoviesContract {

    public static final String CONTENT_AUTHORITY = "com.example.udacity.movies";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_MOVIES = "movies";

    public static final class MoviesEntry implements BaseColumns {

        public static final String SEGMENT_POPULAR = "popular";
        public static final String SEGMENT_PLAYING = "playing";
        public static final String SEGMENT_RATED = "rated";

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIES).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIES;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIES;

        public static final String TABLE_NAME = "movie";
        public static final String COLUMN_POSTER_PATH = "poster_path";
        public static final String COLUMN_ADULT = "adult";
        public static final String COLUMN_OVERVIEW = "overview";
        public static final String COLUMN_RELEASE_DATE = "release_date";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_ORIGINAL_TITLE = "original_title";
        public static final String COLUMN_ORIGINAL_LANG = "original_language";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_BACKDROP_PATH = "backdrop_path";
        public static final String COLUMN_POPULARITY = "popularity";
        public static final String COLUMN_VOTE_COUNT = "vote_count";
        public static final String COLUMN_VOTE_AVG = "vote_average";

        public static final String[] PROJECTION = {
                COLUMN_POSTER_PATH,
                COLUMN_ADULT,
                COLUMN_OVERVIEW,
                COLUMN_RELEASE_DATE,
                COLUMN_MOVIE_ID,
                COLUMN_ORIGINAL_TITLE,
                COLUMN_ORIGINAL_LANG,
                COLUMN_TITLE,
                COLUMN_BACKDROP_PATH,
                COLUMN_POPULARITY,
                COLUMN_VOTE_COUNT,
                COLUMN_VOTE_AVG
        };

        public static Uri buildMovieWithIdUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildMovieWithPopularUri(long id) {
            return CONTENT_URI.buildUpon()
                    .appendPath(SEGMENT_POPULAR)
                    .build();
        }

        public static Uri buildMovieWithNowPlayingUri(long id) {
            return CONTENT_URI.buildUpon()
                    .appendPath(SEGMENT_PLAYING)
                    .build();
        }

        public static Uri buildMovieWithTopRatedUri(long id) {
            return CONTENT_URI.buildUpon()
                    .appendPath(SEGMENT_RATED)
                    .build();
        }

        public static long getMovieIdFromUri(Uri uri) {
            return Long.parseLong(uri.getPathSegments().get(1));
        }
    }

}
