package org.wb.games.towerdefense.game;


public class Checkpoint {

    private final int tileX;
    private final int tileY;

    public Checkpoint(int tileX, int tileY) {
        this.tileX = tileX;
        this.tileY = tileY;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }
}
