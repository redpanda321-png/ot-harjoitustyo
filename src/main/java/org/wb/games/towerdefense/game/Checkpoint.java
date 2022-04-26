package org.wb.games.towerdefense.game;


public class Checkpoint {

    private final int tileX;
    private final int tileY;
    private final int order;

    public Checkpoint(int tileX, int tileY, int order) {
        this.tileX = tileX;
        this.tileY = tileY;
        this.order = order;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }
}
