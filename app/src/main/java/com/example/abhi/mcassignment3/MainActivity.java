package com.example.abhi.mcassignment3;

import android.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager = getFragmentManager();

    private final View.OnClickListener spButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragLayout, SharedPreferences.newInstance());
            transaction.commit();
        }
    };

    private final View.OnClickListener fileButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragLayout, FileFragment.newInstance());
            transaction.commit();
        }
    };

    private final View.OnClickListener sqlButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragLayout, SqlFragment.newInstance());
            transaction.commit();
        }
    };

    private final View.OnClickListener viewButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragLayout, ViewFragment.newInstance());
            transaction.commit();
        }
    };

    private void associateOnClickListeners(){
        findViewById(R.id.spButton).setOnClickListener(spButtonListener);
        findViewById(R.id.fileButton).setOnClickListener(fileButtonListener);
        findViewById(R.id.sqlButton).setOnClickListener(sqlButtonListener);
        findViewById(R.id.viewButton).setOnClickListener(viewButtonListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        associateOnClickListeners();
    }

}
