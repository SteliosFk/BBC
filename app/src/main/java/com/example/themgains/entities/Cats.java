package com.example.themgains.entities;

import android.media.Image;

public class Cats {

    private String name;
    private Rarities rarity;

    private int str;
    private int def;

    private Image image;
    public String imagePath;

    public Cats(String name, Rarities rarity) {
        this.name = name;
        this.rarity = rarity;
        this.str = 0;
        this.def = 0;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void changeStats(int str, int def) {
        this.str = str;
        this.def = def;
    }

    public int getStr() {
        return str;
    }

    public int getDef() {
        return def;
    }
    public void setDef(int def) { this.def = def; }

    public String getName() {
        return name;
    }

    public Rarities getRarity() {
        return rarity;
    }

}
