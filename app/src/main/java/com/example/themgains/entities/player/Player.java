package com.example.themgains.entities.player;

import com.example.themgains.entities.Cats;
import com.example.themgains.entities.cats.CosmicCat;
import com.example.themgains.entities.cats.Pedro;

import java.util.ArrayList;
import java.util.Collections;

public class Player {

    public ArrayList<Cats> cardsInDeck = new ArrayList<>();
    public Cats currentCard;

    public Player() {
        fillDeck();
    }

    public void fillDeck() {
        cardsInDeck.add(new Pedro());
        cardsInDeck.add(new CosmicCat());

        Collections.shuffle(cardsInDeck);
    }

    public boolean canDraw() {
        if (cardsInDeck.size() > 0 && currentCard == None) {
            return true;
        }
        return false;
    }

}
