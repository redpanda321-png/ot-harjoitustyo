package org.wb.games.towerdefense.ui;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.wb.games.towerdefense.game.Game;

import static org.wb.games.towerdefense.ui.TowerDefense.SCREEN_HEIGHT;
import static org.wb.games.towerdefense.ui.TowerDefense.SCREEN_WIDTH;


public class Scene implements ApplicationListener {

    private Game game;
    private BitmapFont font;
    private SpriteBatch batch;
    public static int state;
    private boolean inGame;
    private boolean inMenu;
    private Menu menu;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.BROWN);

        state = 0;
        inGame = false;
        inMenu = false;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if (state == 0) {
            inGame = false;
            if (!inMenu) {

                startMenu();
            }
            menu.drawMenu();

        } else if (state == 1) {
            inMenu = false;
            if (!inGame) {

                startGame();
            }

            game.render();
            font.draw(batch, game.mousePosition(), SCREEN_WIDTH - 208, SCREEN_HEIGHT - 150);
            font.draw(batch, "Press esc to return to menu", SCREEN_WIDTH - 208, SCREEN_HEIGHT - 50);
        }
        batch.end();

    }

    public void startMenu() {
        menu = new Menu();
        inMenu = true;
    }

    public void startGame() {
        game = new Game("tilemap");
        inGame = true;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
