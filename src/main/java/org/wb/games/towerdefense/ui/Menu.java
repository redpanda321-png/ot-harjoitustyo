package org.wb.games.towerdefense.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import org.lwjgl.system.CallbackI;
import org.wb.games.towerdefense.ui.Scene;

import org.wb.games.towerdefense.helpers.FileReader;

import static org.wb.games.towerdefense.ui.TowerDefense.SCREEN_HEIGHT;
import static org.wb.games.towerdefense.ui.TowerDefense.SCREEN_WIDTH;


public class Menu implements InputProcessor {

    private final Skin skin;
    private final Stage stage;
    private final SpriteBatch batch;

    public Menu() {
        Gdx.input.setInputProcessor(this);

        batch = new SpriteBatch();
        skin = FileReader.loadUiSkin();
        stage = new Stage();

        stage.addActor(createButton(200, 20, (float) SCREEN_WIDTH / 2, (float) SCREEN_HEIGHT / 2, "Click here to begin"));
        Gdx.input.setInputProcessor(stage);
    }

    public void drawMenu() {
        batch.begin();
        stage.draw();
        batch.end();
    }

    public TextButton createButton(float width, float height, float positionX, float positionY, String text) {
        final TextButton button = new TextButton(text, skin, "default");
        button.setWidth(width);
        button.setHeight(height);
        button.setPosition(positionX - (width / 2), positionY - (height / 2));

        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                startGame();
            }
        });

        return button;
    }

    public void exit() {
        dispose();
        Gdx.app.exit();
    }

    private void dispose() {
        batch.dispose();
    }

    public void startGame() {
        Scene.state = 1;
        dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            startGame();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            exit();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

}
