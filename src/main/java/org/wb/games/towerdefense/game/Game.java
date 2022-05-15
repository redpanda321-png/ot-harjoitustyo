package org.wb.games.towerdefense.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import org.wb.games.towerdefense.ui.Map;
import org.wb.games.towerdefense.ui.Scene;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.wb.games.towerdefense.helpers.Utils.calculateDuration;
import static org.wb.games.towerdefense.ui.TowerDefense.*;


public class Game implements InputProcessor {
    private final OrthogonalTiledMapRenderer tiledMapRenderer;
    private final OrthographicCamera camera;
    private final TiledMapTileLayer layer;
    private final Map map;
    private final Vector3 mousePos;
    private final Stage stage;
    private final Path path;
    private final List<Monster> monsters = new ArrayList<>();
    private final List<Tower> towers = new ArrayList<>();
    private final List<Projectile> arrows = new ArrayList<>();
    private final TiledMapTile towerTile;

    private final float tileWidth;
    private final float tileHeight;

    private final static float MONSTER_TIME_OUT = 4;
    private float monsterTime = 0;
    private final static float ARROW_TIME_OUT = 3;
    private float arrowTime = 0;
    private int score = 0;

    public Game(final String mapName) {
        Gdx.input.setInputProcessor(this);
        this.map = new Map(mapName);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map.getMap());
        camera = new OrthographicCamera();
        camera.setToOrtho(false, map.getWidth() / ASPECT_RATIO, map.getHeight());
        layer = map.getGameLayer();
        towerTile = map.getMap().getTileSets().getTileSet("TilesetElement").getTile(897);
        path = new Path(map.getMap());
        mousePos = new Vector3();
        stage = new Stage();

        tileHeight = (float) SCREEN_HEIGHT / map.getHeight();
        tileWidth = (float) ((int) camera.viewportWidth) / map.getMapWidth();
    }


    public void render() {

        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        mouseUpdate();
        float dt = Gdx.graphics.getDeltaTime();
        monsterTime += dt;
        arrowTime += dt;

        if (monsterTime > MONSTER_TIME_OUT) {
            final Monster monster = monsterCreate();
            stage.addActor(monster);
            monsters.add(monster);
            monsterTime -= MONSTER_TIME_OUT;
        }

        if (arrowTime > ARROW_TIME_OUT) {
            towers.forEach(tower -> {
                var arrow = tower.shoot(tileWidth, tileHeight * map.getTileHeight());
                stage.addActor(arrow);
                arrows.add(arrow);
            });
            removeArrows();
            arrowTime -= ARROW_TIME_OUT;

        }
        if (!monsters.isEmpty()) {
            detectCollision();
        }

        stage.act(dt);
        stage.draw();
        camera.unproject(mousePos);
    }

    private void removeArrows() {
        arrows.removeIf(arrow -> arrow.getStage() == null);
    }

    private MoveToAction createMoveToAction(final Checkpoint checkpoint) {
        MoveToAction moveToCheckpoint = new MoveToAction();
        float x = (float) checkpoint.getTileX() * tileWidth + tileWidth / 2;
        float y = (float) checkpoint.getTileY() * map.getTileHeight() * tileHeight;
        moveToCheckpoint.setPosition(x, y);
        return moveToCheckpoint;
    }


    private Monster monsterCreate() {
        Monster monster = new Monster();
        monster.setPosition(map.getTileWidth() * 4 + monster.getWidth() / 2, SCREEN_HEIGHT - monster.getHeight());

        SequenceAction sequenceAction = new SequenceAction();
        Checkpoint previousPoint = new Checkpoint(4, 1);
        for (Checkpoint checkpoint : path.getCheckpoints()) {
            MoveToAction moveToAction = createMoveToAction(checkpoint);
            moveToAction.setDuration(calculateDuration(previousPoint, checkpoint));
            sequenceAction.addAction(moveToAction);
            previousPoint = checkpoint;
        }
        sequenceAction.addAction(Actions.removeActor());
        monster.addAction(sequenceAction);

        return monster;
    }

    private void detectCollision() {
        Iterator<Monster> monsterIterator = monsters.iterator();
        while (monsterIterator.hasNext()) {
            Monster monster = monsterIterator.next();
            Iterator<Projectile> arrowIterator = arrows.iterator();
            while (arrowIterator.hasNext()) {
                Projectile arrow = arrowIterator.next();
                boolean hit = monster.collides(arrow.getX(), arrow.getY());
                if (hit) {
                    addScore();
                    arrow.remove();
                    arrowIterator.remove();
                    monster.die();
                    monsterIterator.remove();
                    break;
                }
            }
        }
    }

    private void addScore() {
        score++;
    }

    public int getScore() {
        return score;
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
        final Tower tower = Tower.createTower(cellX, cellY, layer, towerTile);
        if (tower != null) {
            towers.add(tower);
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

    public void dispose() {
        monsters.forEach(Monster::dispose);
        arrows.forEach(Projectile::dispose);
    }

    public void mouseUpdate() {
        mousePos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
    }

    public String mousePosition() {
        return "x: " + (int) mousePos.x + ", " + "y: " + (int) mousePos.y;
    }
}
