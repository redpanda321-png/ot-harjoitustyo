package org.wb.games.towerdefense.ui;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Map {

    String mapName;
    public TiledMap gameMap;
    TiledMapTileLayer gameLayer;


    public Map(String mapName) {
        this.mapName = mapName;
        this.gameMap = new TmxMapLoader().load("src/assets/Tile/" + mapName + ".tmx");
        this.gameLayer = (TiledMapTileLayer) gameMap.getLayers().get("Game");
    }

    public TiledMap getMap() {
        return gameMap;
    }

    public TiledMapTileLayer getGameLayer() {
        return gameLayer;
    }

    public int getMapWidth() {
        return (int) gameMap.getProperties().get("width");
    }

    public int getWidth() {
        return (int) gameMap.getProperties().get("width") * (int) gameMap.getProperties().get("tilewidth");
    }

    public int getHeight() {
        return (int) gameMap.getProperties().get("height") * (int) gameMap.getProperties().get("tileheight");
    }

    public int getTileWidth() {
        return (int) gameMap.getProperties().get("tilewidth");
    }

    public int getTileHeight() {
        return (int) gameMap.getProperties().get("tileheight");
    }
}
