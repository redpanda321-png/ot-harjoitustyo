package org.wb.games.towerdefense.game;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class Tower {

    public int towerCount;
    private final int cellX;
    private final int cellY;


    private Tower(int cellX, int cellY) {
        this.cellX = cellX;
        this.cellY = cellY;
    }

    public Projectile shoot(float tileWidth, float tileHeight) {
        Projectile arrow = new Projectile();
        arrow.setPosition(tileWidth * cellX, tileHeight * cellY);
        MoveToAction moveToAction = new MoveToAction();
        moveToAction.setPosition(tileWidth * 32, tileHeight * cellY);
        arrow.addAction(moveToAction);
        return arrow;
    }

    public static Tower createTower(int cellX, int cellY, TiledMapTileLayer layer, TiledMapTile tile) {
        if (layer.getCell(cellX, cellY) == null) {
            var cell = new TiledMapTileLayer.Cell();
            cell.setTile(tile);
            layer.setCell(cellX, cellY, cell);
            return new Tower(cellX, cellY);
        }
        return null;
    }


    public int getTowerCount() {
        return towerCount;
    }
}

