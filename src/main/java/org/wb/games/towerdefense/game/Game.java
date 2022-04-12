package org.wb.games.towerdefense.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

import org.wb.games.towerdefense.ui.Map;

import static org.wb.games.towerdefense.ui.TowerDefense.*;


public class Game implements InputProcessor {
    private final OrthogonalTiledMapRenderer tiledMapRenderer;
    private final OrthographicCamera camera;
    private final TiledMapTileLayer layer;
    private int towerCount = 0;
    private final Monster redCyclops;
    private final Map map;
    private final Tower stoneTower;
    private final Vector3 mousePos;


    public Game(final String mapName, final SpriteBatch batch) {
        this.map = new Map(mapName);

        tiledMapRenderer = new OrthogonalTiledMapRenderer(map.getMap());
        camera = new OrthographicCamera();

        camera.setToOrtho(false, map.getWidth() / ASPECT_RATIO, map.getHeight());
        Gdx.input.setInputProcessor(this);          //

        layer = map.getGameLayer();
//        stoneTower = new Tower("Stone tower", 897, map.getMap().getTileSets().getTileSet("TilesetElement"));
        stoneTower = new Tower("Stone tower", map.getMap().getTileSets().getTileSet("TilesetElement").getTile(897));

        redCyclops = new Monster(batch);
        redCyclops.setPosition(map.getTileWidth() * 4 + redCyclops.getWidth() / 2, SCREEN_HEIGHT - redCyclops.getHeight());

        mousePos = new Vector3();
    }

    public void render() {
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        redCyclops.render();
        mouseUpdate();
        camera.unproject(mousePos);
    }

    @Override
    public boolean keyDown(final int keycode) {
        System.out.println("Key pressed: " + Input.Keys.toString(keycode) + " :" + keycode);
        return false;
    }

    @Override
    public boolean keyUp(final int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(final char character) {
        return false;
    }

    @Override
    public boolean touchDown(final int screenX, final int screenY, final int pointer, final int button) {
        System.out.println(screenX + ", " + screenY + ", " + pointer + ", " + button);

        final int cellX = (int) mousePos.x / map.getTileWidth();
        final int cellY = (int) mousePos.y / map.getTileWidth();

        if(stoneTower.buildTower(cellX, cellY, layer)) {
            towerCount++;
        }
        return false;
    }

    @Override
    public boolean touchUp(final int screenX, final int screenY, final int pointer, final int button) {
        return false;
    }

    @Override
    public boolean touchDragged(final int screenX, final int screenY, final int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(final int screenX, final int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(final float amountX, final float amountY) {
        return false;
    }


    public int getTowerCount() {
        return towerCount;
    }

    public void dispose() {
        redCyclops.dispose();
    }

    public void mouseUpdate() {
        mousePos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
    }

    public String mousePosition() {
        return "x: " + (int) mousePos.x + ", " + "y: " + (int) mousePos.y;
    }

    public float getMouseX() {
        return mousePos.x;
    }

    public float getMouseY() {
        return mousePos.y;
    }
}
