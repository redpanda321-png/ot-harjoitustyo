package org.wb.games.towerdefense.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import org.wb.games.towerdefense.helpers.FileReader;

public class Projectile extends Actor {

    public Projectile() {
        Texture texture = FileReader.loadArrow();
        final Sprite sprite = new Sprite(texture);

        setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());
    }
}
