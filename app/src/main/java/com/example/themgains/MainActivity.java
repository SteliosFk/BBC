package com.example.themgains;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themgains.entities.CatsHandler;

public class MainActivity extends AppCompatActivity {
    public CatsHandler catsHandler = new CatsHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        catsHandler.implement();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}