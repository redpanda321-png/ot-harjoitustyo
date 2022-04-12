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

    Game game;
    private BitmapFont font;
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        game = new Game ("tilemap", batch);
        font = new BitmapFont();
        font.setColor(Color.BROWN);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.render();
        batch.begin();
        font.draw(batch, "Tower count: " + game.getTowerCount(), SCREEN_WIDTH - 208, SCREEN_HEIGHT - 10);
        batch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
    }
}
