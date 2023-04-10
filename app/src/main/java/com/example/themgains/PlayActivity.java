package com.example.themgains;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themgains.entities.Cats;
import com.example.themgains.entities.CatsHandler;
import com.example.themgains.entities.cats.NoneCat;
import com.example.themgains.entities.player.Player;

public class PlayActivity extends AppCompatActivity {
    public CatsHandler catsHandler = new CatsHandler();

    public Player plr;
    public Player plrE;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        catsHandler.implement();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        plr = new Player();
        plrE = new Player();

        plrE.currentCard = plrE.cardsInDeck.get(0);
        plrE.cardsInDeck.remove(0);
    }

    public void FIGHT(View view) {
        if (plr.currentCard.name == new NoneCat().name) {
            System.out.println("You aint got a card you monkey!");
        } else if (plrE.currentCard.name == new NoneCat().name) {
            if (plrE.cardsInDeck.size() > 0) {
                plrE.currentCard = plrE.cardsInDeck.get(0);
                plrE.cardsInDeck.remove(0);
                catsHandler.battleLoop(plr, plrE);
            } else {
                System.out.println("You won nice, idc though");
            }
        } else {
            catsHandler.battleLoop(plr, plrE);
        }
    }

    public void drawCard(View view) {
        System.out.println("======================================");
        System.out.println("> Button clicked");
        System.out.println("> Attempting to draw card...");

        if (plr.canDraw()) {
            i = (int)Math.floor(Math.random() * (plr.cardsInDeck.size() - 0 + 1) + 0);
            plr.currentCard = plr.cardsInDeck.get(0);

            System.out.println("> Drawn card: " + plr.cardsInDeck.get(0).name);
            plr.cardsInDeck.remove(0);

            System.out.println("> Printing deck(" + plr.cardsInDeck.size() + "): ");
            for (Cats c : plr.cardsInDeck) System.out.println("● " + c.name);
        } else {
            System.out.println("> Can't draw card...");
        }
        System.out.println("======================================");
    }
}