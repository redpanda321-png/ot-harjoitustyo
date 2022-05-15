package org.wb.games.towerdefense.helpers;

import org.wb.games.towerdefense.game.Checkpoint;

public final class Utils {

    private Utils() {

    }

    public static float calculateDuration(Checkpoint previous, Checkpoint current) {
        return calculateDuration(previous.getTileX(), previous.getTileY(), current.getTileX(), current.getTileY());
    }

    public static float calculateDuration(int previousX, int previousY, int currentX, int currentY) {
        return previousX != currentX ?
                (float) Math.abs(previousX - currentX) / 3 :
                (float) Math.abs(previousY - currentY) / 3;
    }
}
