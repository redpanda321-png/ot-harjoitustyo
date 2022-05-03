package org.wb.games.towerdefense.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class FileReader {

    Skin skin;




    public void createSkin() {
        skin = new Skin(Gdx.files.internal("assets/UI/uiskin.json"));
    }


    public Skin getSkin() {
        return skin;
    }

    public TextureAtlas loadMonster() {
        return new TextureAtlas(Gdx.files.internal("assets/Monster/RedCyclops/RedCyclops.atlas"));
    }

    public TiledMap loadMap(String mapName) {
        return new TmxMapLoader().load("assets/Tile/" + mapName + ".tmx");
    }
}
