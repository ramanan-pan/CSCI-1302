package cs1302.mygame;

import cs1302.game.GameObject;

public class PlayableCharacter extends Character {

    private long exp;

    public PlayableCharacter(String name, long exp) {
        super(name);
        this.exp = exp;
    }
}
