package org.wb.games.towerdefense.ui;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import org.wb.games.towerdefense.helpers.FileReader;

public class Map {

    String mapName;
    public TiledMap gameMap;
    TiledMapTileLayer gameLayer;


    public Map(String mapName) {
        FileReader fileReader = new FileReader();
        this.mapName = mapName;
//        this.gameMap = new TmxMapLoader().load("src/assets/Tile/" + mapName + ".tmx");
        this.gameMap = fileReader.loadMap(mapName);

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
