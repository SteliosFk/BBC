package com.example.themgains.entities.cats;

import com.example.themgains.entities.Cats;
import com.example.themgains.entities.Element;
import com.example.themgains.entities.Rarities;

public class Pedro extends Cats {
    public Pedro() {
        super("Pedro", Rarities.Epic, Element.Red);
        str = 5;
        def = 20;
        speed = 9999;
    }

    @Override
    public void passives(Cats enemy) {
        speed = 9999;
    }
}
