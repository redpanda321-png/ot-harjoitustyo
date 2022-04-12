package org.wb.games.towerdefense.game;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Tower {

    private final String name;
    private final TiledMapTileLayer.Cell tower;
    public int towerCount;

    public Tower(String name, TiledMapTile tile) {
        this.name = name;

        tower = new TiledMapTileLayer.Cell();
        tower.setTile(tile);
    }



    public boolean buildTower(int cellX, int cellY, TiledMapTileLayer layer) {
        if (layer.getCell(cellX, cellY) == null) {
            layer.setCell(cellX, cellY, tower);
            towerCount++;
            System.out.println(tower.getTile().getId());
            return true;
        }
        return false;
    }

}

