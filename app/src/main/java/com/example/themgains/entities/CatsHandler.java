package com.example.themgains.entities;

import com.example.themgains.entities.cats.CosmicCat;
import com.example.themgains.entities.cats.Pedro;

import java.util.ArrayList;
import java.util.List;

public class CatsHandler {

    protected List<Cats> cats = new ArrayList<>();

    public void add(Cats c) {
        cats.add(c);
    }

    public void remove(Cats c) {
        cats.remove(c);
    }

    public void implement() {
        add(new Pedro());
        add(new CosmicCat());
    }

    public int elementCase(Cats c1, Cats c2) {
        if ((c1.element == Element.Red && c2.element == Element.Green) || (c1.element == Element.Green && c2.element == Element.Blue) || (c1.element == Element.Blue && c2.element == Element.Red)) {
            return 1;
        } else if ((c2.element == Element.Red && c1.element == Element.Green) || (c2.element == Element.Green && c1.element == Element.Blue) || (c2.element == Element.Blue && c1.element == Element.Red)) {
            return 2;
        }
        return 0;
    }

    public void battleLoop(Cats c1, Cats c2) {
        boolean finished = false;
        while (!finished) {
            c1.passives(c2);
            c2.passives(c1);

            switch (elementCase(c1, c2)) {
                case 1:
                    c1.str++;
                    c2.str--;
                    break;
                case 2:
                    c2.str++;
                    c1.str--;
                    break;
            }
            //=======================================================================

            if (c1.speed > c2.speed) {
                c2.def -= c1.str;
                if (c2.def > 0) c1.def -= c2.str;
            }else if (c2.speed > c1.speed) {
                c1.def -= c2.str;
                if (c1.def > 0) c1.def -= c2.str;
            } else {
                c2.def -= c1.str;
                c1.def -= c2.str;
            }

            //=======================================================================
            switch (elementCase(c1, c2)) {
                case 1:
                    c1.str--;
                    c2.str++;
                    break;
                case 2:
                    c2.str--;
                    c1.str++;
                    break;
            }

            System.out.println(c1.name + "\nHp:" + c1.def + "\n\n\n");
            System.out.println(c2.name + "\nHp:" + c2.def + "\n");
            System.out.println("==============================================");
            if (c1.def <= 0 || c2.def <= 0) finished = true;
        }
    }

}
