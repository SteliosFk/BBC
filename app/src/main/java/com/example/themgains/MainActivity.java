package com.example.themgains;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    public void play(View view) {
        System.out.println("======================================");
        System.out.println("> Button clicked");
        System.out.println("> Switching...");

        try {
            Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
            startActivity(intent);
            System.out.println("> Switch successful");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("======================================");
    }
}