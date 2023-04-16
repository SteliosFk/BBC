package com.example.themgains;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cards = findViewById(R.id.cardsButton);
        Button notes = findViewById(R.id.notesButton);

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //notes intent
            }
        });

        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cards intent
            }
        });
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