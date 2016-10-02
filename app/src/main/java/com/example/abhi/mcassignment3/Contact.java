package com.example.abhi.mcassignment3;

import android.provider.BaseColumns;

/**
 * Created by Abhi on 02-10-2016.
 */
public final class Contact {
    private Contact(){}

    public static class ContactEntry implements BaseColumns{
        public static final String TABLE_NAME = "Contact";
        public static final String COLUMN_NAME_NAME = "Name";
        public static final String COLUMN_NAME_NUMBER = "Number";
    }
}
