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


public class Menu {

    private final Skin skin;
    private final Stage stage;
    private final SpriteBatch batch;

    public Menu() {

        batch = new SpriteBatch();
        skin = FileReader.loadUiSkin();
        stage = new Stage();
        final TextButton startButton = createButton(200, 20, (float) SCREEN_WIDTH / 2, (float) SCREEN_HEIGHT / 2, "Click here to begin");
        startButton.addListener(startGameClick());

        final TextButton exitButton = createButton(80, 20, (float) SCREEN_WIDTH / 2, (float) SCREEN_HEIGHT / 2 - 80, "Exit");
        exitButton.addListener(exitGameClick());
        stage.addActor(startButton);
        stage.addActor(exitButton);

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
        return button;
    }

    public ClickListener startGameClick() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                startGame();
            }
        };
    }

    public ClickListener exitGameClick() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        };
    }

    private void dispose() {
        batch.dispose();
    }

    public void startGame() {
        Scene.state = 1;
        dispose();
    }
}
