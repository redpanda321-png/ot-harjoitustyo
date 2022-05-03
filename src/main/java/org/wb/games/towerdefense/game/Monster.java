package org.wb.games.towerdefense.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import org.wb.games.towerdefense.helpers.FileReader;

public class Monster extends Actor {

    private final Animation<TextureAtlas.AtlasRegion> animation;
    private float elapsedTime = 0;
    private final TextureAtlas monsterTextureAtlas;

    private int checkpointReached;

    public Monster() {
        monsterTextureAtlas = FileReader.loadMonster();
        animation = new Animation<>(1 / 10f, monsterTextureAtlas.getRegions());
        final var texture = animation.getKeyFrame(elapsedTime);
        setBounds(getX(), getY(), texture.originalWidth, texture.originalHeight);
        this.checkpointReached = 0;

    }

    @Override
    public void draw(final Batch batch, final float parentAlpha) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(elapsedTime, true), getX(), getY());
    }

    public void dispose() {
        monsterTextureAtlas.dispose();
    }

    public int getCheckpointReached() {
        return checkpointReached;
    }

    public void setCheckpointReached(int checkpointReached) {
        this.checkpointReached = checkpointReached;
    }
}
