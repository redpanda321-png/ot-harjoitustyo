package org.wb.games.towerdefense.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import org.wb.games.towerdefense.helpers.FileReader;


public class Projectile extends Actor {

    Texture texture;

    public Projectile() {
        this.texture = FileReader.loadArrow();
        setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());
    }

    @Override
    public void draw(final Batch batch, final float parentAlpha) {
        batch.draw(texture, getX(), getY());
    }

    public void dispose() {
        texture.dispose();
    }
}