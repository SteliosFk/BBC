package com.example.themgains;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themgains.entities.CatsHandler;
import com.example.themgains.entities.cats.CosmicCat;
import com.example.themgains.entities.cats.Pedro;

public class MainActivity extends AppCompatActivity {
    public CatsHandler catsHandler = new CatsHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        catsHandler.implement();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catsHandler.battleLoop(new CosmicCat(), new Pedro());
    }
}