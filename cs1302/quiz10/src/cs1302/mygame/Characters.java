package cs1302.mygame;

import cs1302.game.GameObject;

public abstract class Characters extends GameObject {
    private String name;
    private int hp;

    public Characters(String name) {
        this.name = name;
    }

}
