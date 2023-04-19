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
                Intent notesIntent = new Intent(getApplicationContext(), NotesActivity.class);
                startActivity(notesIntent);
            }
        });

        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), CardsActivity.class);
                Intent intent = new Intent(getApplicationContext(), CosmicActivity.class);
                startActivity(intent);
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