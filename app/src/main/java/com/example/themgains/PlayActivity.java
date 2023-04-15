package com.example.themgains;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themgains.entities.Cats;
import com.example.themgains.entities.CatsHandler;
import com.example.themgains.entities.cats.NoneCat;
import com.example.themgains.entities.player.Player;

public class PlayActivity extends AppCompatActivity {
    public CatsHandler catsHandler = new CatsHandler();
    protected boolean viewsPlayer = true;

    ImageView plrImg;

    Intent intent;

    TextView hpText;
    TextView atkText;

    public Player plr;
    public Player plrE;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        catsHandler.implement();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        hpText = findViewById(R.id.TextViewHp);
        atkText = findViewById(R.id.TextViewAtk);

        plrImg = findViewById(R.id.currentCard);

        plr = new Player();
        plrE = new Player();

        plrE.currentCard = plrE.cardsInDeck.get(0);
        plrE.cardsInDeck.remove(0);

        Button btnFight = findViewById(R.id.fightButton);
        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FIGHT(view);
            }
        });

        Button btnSwitchView = findViewById(R.id.toggleBetweenViewButton);
        btnSwitchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewsPlayer) {
                    plrImg.setImageResource(plrE.currentCard == new NoneCat() ? null : plrE.currentCard.img);
                    hpText.setText("Hp: " + plrE.currentCard.def);
                    atkText.setText("Str: " + plrE.currentCard.str);

                    btnSwitchView.setText("PLAYER");
                    viewsPlayer = false;
                } else {
                    plrImg.setImageResource(plr.currentCard == new NoneCat() ? null : plr.currentCard.img);
                    hpText.setText("Hp: " + plr.currentCard.def);
                    atkText.setText("Str: " + plr.currentCard.str);

                    btnSwitchView.setText("ENEMY");
                    viewsPlayer = true;
                }
            }
        });

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
        if (viewsPlayer) {
            plrImg.setImageResource(plr.currentCard == new NoneCat() ? null : plr.currentCard.img);
            hpText.setText("Hp: " + plr.currentCard.def);
            atkText.setText("Str: " + plr.currentCard.str);
        } else {
            plrImg.setImageResource(plrE.currentCard == new NoneCat() ? null : plrE.currentCard.img);
            hpText.setText("Hp: " + plrE.currentCard.def);
            atkText.setText("Str: " + plrE.currentCard.str);
        }
        if (plrE.currentCard == new NoneCat() && plrE.cardsInDeck.size() <= 0) {
            setContentView(R.layout.activity_win);
        }
        intent = new Intent(getApplicationContext(), WinActivity.class);
        startActivity(intent);
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
        if (viewsPlayer) {
            plrImg.setImageResource(plr.currentCard == new NoneCat() ? null : plr.currentCard.img);
            hpText.setText("Hp: " + plr.currentCard.def);
            atkText.setText("Str: " + plr.currentCard.str);
        } else {
            plrImg.setImageResource(plrE.currentCard == new NoneCat() ? null : plrE.currentCard.img);
            hpText.setText("Hp: " + plrE.currentCard.def);
            atkText.setText("Str: " + plrE.currentCard.str);
        }
    }
}