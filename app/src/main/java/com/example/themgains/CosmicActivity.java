package com.example.themgains;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themgains.entities.Cats;
import com.example.themgains.entities.player.Player;

public class CosmicActivity extends AppCompatActivity {

    protected int[] cats;
    protected int currentlyDisplaying = 0;

    ImageView displayImg;

    Player plr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmic);

        plr = new Player();
        for (Cats cat : plr.notSuffledDeck) {
            cats[cats.length - 1] = cat.displayImg;
        }

        displayImg = findViewById(R.id.displayedImage);

        //================Buttons
        findViewById(R.id.nextCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentlyDisplaying + 1 <= cats.length - 1) {
                    currentlyDisplaying++;
                } else {
                    currentlyDisplaying = 0;
                }
                displayImg.setImageResource(cats[currentlyDisplaying]);
            }
        });

        findViewById(R.id.cosmicGoBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CardsActivity.class);
                startActivity(intent);
            }
        });
    }
}