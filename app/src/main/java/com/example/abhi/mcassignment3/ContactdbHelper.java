package com.example.abhi.mcassignment3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abhi on 02-10-2016.
 */

public class ContactdbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Contact.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " VARCHAR";
    private static final String COMMA = ", ";
    private static final String SQL_CREATE =
            "CREATE TABLE " + Contact.ContactEntry.TABLE_NAME + " (" +
                    Contact.ContactEntry._ID + " INTEGER PRIMARY KEY" + COMMA +
                    Contact.ContactEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA +
                    Contact.ContactEntry.COLUMN_NAME_NUMBER + TEXT_TYPE + " )";


    public ContactdbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
