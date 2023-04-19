package com.example.themgains;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CosmicActivity extends AppCompatActivity {

    protected int[] cats = {R.drawable.cosmiccatdisplay, R.drawable.nullcheck};
    protected int currentlyDisplaying = 0;

    ImageView displayImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmic);

        displayImg = findViewById(R.id.displayedImage);

        //================Buttons
        findViewById(R.id.nextCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentlyDisplaying < cats.length) {
                    currentlyDisplaying++;
                } else {
                    currentlyDisplaying = 0;
                }
                displayImg.setImageResource(cats[currentlyDisplaying] == R.drawable.nullcheck ? null : cats[currentlyDisplaying]);
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