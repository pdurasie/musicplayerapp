package com.example.android.musicplayerapp;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class SpinnerActivity extends LibraryActivity implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       Log.i("SpinnerActivity", "item selected");
        //Object item = parent.getItemAtPosition(position);
       //item.
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.i("SpinnerActivity", "nothing selected");
    }
}
