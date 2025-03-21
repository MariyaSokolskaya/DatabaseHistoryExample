package com.example.databaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    //TODO набор констант с названиями
    static final String DATABASE_NAME = "History.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_EVENTS = "Events";
    static final String EVENTS_START_DATE = "Start_date";
    static final String EVENTS_END_DATE = "End_date";
    static final String EVENTS_NAME = "Name";
    static final String EVENTS_PERSONES = "Persones";
    static final String EVENTS_DESCRIPTION = "Description";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_EVENTS +
                "( _id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EVENTS_START_DATE + " TEXT,"
                + EVENTS_END_DATE + " TEXT,"
                + EVENTS_NAME + " TEXT,"
                + EVENTS_PERSONES + " TEXT,"
                + EVENTS_DESCRIPTION + " TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
