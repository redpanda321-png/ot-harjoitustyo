package org.wb.games.towerdefense.game;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

import static org.wb.games.towerdefense.helpers.Utils.calculateDuration;

public class Tower {

    public int towerCount;
    private final int cellX;
    private final int cellY;


    private Tower(int cellX, int cellY) {
        this.cellX = cellX;
        this.cellY = cellY;
    }

    public Projectile shoot(float tileWidth, float tileHeight) {
        float y = tileHeight * cellY + tileHeight / 2;
        int cells = 35;
        Projectile arrow = new Projectile();
        arrow.setPosition(tileWidth * cellX + tileWidth * 2, y);
        SequenceAction sequenceAction = new SequenceAction();
        MoveToAction moveToAction = new MoveToAction();
        moveToAction.setPosition(tileWidth * cells, y);
        moveToAction.setDuration(calculateDuration(cellX, cellY, cells, cellY) * 0.3f);
        sequenceAction.addAction(moveToAction);
        sequenceAction.addAction(Actions.removeActor());
        arrow.addAction(sequenceAction);
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
}