package org.wb.games.towerdefense.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {

    String mapName;
    static TiledMap gameMap;
    int width;
    int height;
    int tileWidth;
    int tileHeight;



    public Map(String mapName) {
        this.mapName = mapName;
        this.gameMap = new TmxMapLoader().load("src/assets/Tile/" + mapName + ".tmx");
    }

    public static TiledMap getMap() {
        return  gameMap;
    }

    public TiledMapTileLayer getGameLayer() {
        return (TiledMapTileLayer) gameMap.getLayers().get("Game");
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





}
