package com.example.themgains;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themgains.entities.player.Player;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    public static Player plr;
    public static Player plrE;

    public static Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        plr = new Player();
        plrE = new Player();
    }

    public void drawCard() {
        System.out.println("======================================");
        System.out.println("> Button clicked");
        System.out.println("> Attempting to draw card...");

        if (plr.canDraw()) {
            int i = rand.nextInt(plr.cardsInDeck.size()) + 1;
            plr.currentCard = plr.cardsInDeck.get(i);
        } else {
            System.out.println("> Can't draw card...");
        }

        System.out.println("======================================");
    }
}