package org.wb.games.towerdefense.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import org.wb.games.towerdefense.ui.Map;
import org.wb.games.towerdefense.ui.Scene;


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
    private final Stage stage;
    private final Path path;
    private int count = 0;


    public Game(final String mapName) {
        Gdx.input.setInputProcessor(this);

        this.map = new Map(mapName);

        tiledMapRenderer = new OrthogonalTiledMapRenderer(map.getMap());
        camera = new OrthographicCamera();

        camera.setToOrtho(false, map.getWidth() / ASPECT_RATIO, map.getHeight());

        layer = map.getGameLayer();
        stoneTower = new Tower("Stone tower", map.getMap().getTileSets().getTileSet("TilesetElement").getTile(897));

        path = new Path(map.getMap());

        redCyclops = monsterCreate();
//        redCyclops.setPosition(map.getTileWidth() * 4 + redCyclops.getWidth() / 2, SCREEN_HEIGHT - redCyclops.getHeight());

        mousePos = new Vector3();
        stage = new Stage();


        stage.addActor(redCyclops);
    }



    public void render() {

        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        mouseUpdate();
        count++;

        if (count > FRAME_RATE * 4) {
            stage.addActor(monsterCreate());
            count = 0;
        }

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        camera.unproject(mousePos);
    }

    private MoveToAction createMoveToAction(final Checkpoint checkpoint) {
        MoveToAction moveToCheckpoint = new MoveToAction();

        float ratioY = (float) SCREEN_HEIGHT / map.getHeight();
        float tileWidth = (float) ((int) camera.viewportWidth) / map.getMapWidth();

        float x = (float) checkpoint.getTileX() * tileWidth + tileWidth / 2;
        float y = (float) checkpoint.getTileY() * map.getTileHeight() * ratioY;
        moveToCheckpoint.setPosition(x, y);

        return moveToCheckpoint;
    }

    private float calculateDuration(Checkpoint previous, Checkpoint current) {
        return previous.getTileX() != current.getTileX() ?
                (float) Math.abs(previous.getTileX() - current.getTileX()) / 3 :
                (float) Math.abs(previous.getTileY() - current.getTileY()) / 3;
    }

    private Monster monsterCreate() {
        Monster monster = new Monster();
        monster.setPosition(map.getTileWidth() * 4 + monster.getWidth() / 2, SCREEN_HEIGHT - monster.getHeight());

        SequenceAction sequenceAction = new SequenceAction();
        Checkpoint previousPoint = new Checkpoint(4, 1, 0);
        for (Checkpoint checkpoint : path.getCheckpoints()) {
            MoveToAction moveToAction = createMoveToAction(checkpoint);
            moveToAction.setDuration(calculateDuration(previousPoint, checkpoint));
            sequenceAction.addAction(moveToAction);
            previousPoint = checkpoint;
        }
        monster.addAction(sequenceAction);

        return monster;
    }

    @Override
    public boolean keyDown(final int keycode) {
        System.out.println("Key pressed: " + Input.Keys.toString(keycode) + " :" + keycode);
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Scene.state = 0;
            dispose();
        }

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

        System.out.println("cellX: " + cellX + ", cellY: " + cellY);
        if (stoneTower.buildTower(cellX, cellY, layer)) {
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
