package org.wb.games.towerdefense.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class FileReader {

    public static Skin loadUiSkin() {
        return new Skin(Gdx.files.internal("assets/UI/uiskin.json"));
    }

    public static Texture loadArrow() {
        return new Texture(Gdx.files.internal("assets/Projectile/Arrow.png"));
    }

    public static TextureAtlas loadMonster() {
        return new TextureAtlas(Gdx.files.internal("assets/Monster/RedCyclops/RedCyclops.atlas"));
    }

    public static TiledMap loadMap(String mapName) {
        return new TmxMapLoader().load("assets/Tile/" + mapName + ".tmx");
    }
}
