package org.wb.games.towerdefense.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Monster extends Actor {

    private final Animation<TextureAtlas.AtlasRegion> animation;
    private float elapsedTime = 0;
    private final SpriteBatch batch;
    private final TextureAtlas monsterTextureAtlas;

    public Monster(final SpriteBatch batch) {
        this.batch = batch;
        monsterTextureAtlas = new TextureAtlas(Gdx.files.internal("src/assets/Monster/RedCyclops/RedCyclops.atlas"));
        animation = new Animation<>(1/10f, monsterTextureAtlas.getRegions());
        final var texture =animation.getKeyFrame(elapsedTime);
        setBounds(getX(), getY(), texture.originalWidth,texture.originalHeight);

    }

    @Override
    public void draw(final Batch batch, final float parentAlpha) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(elapsedTime, true), getX(), getY());
    }

    public void render() {
        batch.begin();
        draw(batch, 1);
        batch.end();
    }

    public void dispose() {
        monsterTextureAtlas.dispose();
    }

}
