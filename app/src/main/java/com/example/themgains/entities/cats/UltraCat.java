package com.example.themgains.entities.cats;

import com.example.themgains.entities.Cats;
import com.example.themgains.entities.Rarities;

public class UltraCat extends Cats {
    public UltraCat(String name, Rarities rarity) {
        super("Ultra Cat", Rarities.Rare);
        changeStats(75, 750);
    }
}
