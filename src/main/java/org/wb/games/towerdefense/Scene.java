package org.wb.games.towerdefense;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


import static org.wb.games.towerdefense.TowerDefense.SCREEN_HEIGHT;

public class Scene extends Game {
    private Texture textureGrass;
    private Sprite grassTile;
    private Sprite dirtTile;
    private SpriteBatch batch;
    private Pixmap pixmap;
    private Texture textureDirt;
    /*
    int[][] matrix = [
[1, 0, 1, 1],
[1, 0, 0,1],
[1, 1, 0, 1],
[1, 1, 0, 1]]
     */

    private int[][] terrainMatrix = {
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };


    private final static int TILE_SIZE = 32;

    @Override
    public void create() {

        batch = new SpriteBatch();
        pixmap = new Pixmap(TILE_SIZE, TILE_SIZE, Pixmap.Format.RGBA8888);

        pixmap.setColor(Color.rgba8888(0.349f, 0.568f, 0.086f, 1f));
        pixmap.fill();

        textureGrass = new Texture(pixmap);

        pixmap.setColor(Color.rgba8888(0.619f, 0.474f, 0.156f, 1));
        pixmap.fill();
        textureDirt = new Texture(pixmap);

        pixmap.dispose();
        grassTile = new Sprite(textureGrass);
        dirtTile = new Sprite(textureDirt);

    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.WHITE);
        drawTiles();
    }

    private void drawTiles() {

        final int startX = 0;
        final int startY = SCREEN_HEIGHT - TILE_SIZE;
        batch.begin();
        for (int row = 0; row < terrainMatrix.length; row++) {
            final int y = startY - (row * TILE_SIZE);
            for (int col = 0; col < terrainMatrix[row].length; col++) {
                final int x = startX + (col * TILE_SIZE);
                drawTile(x, y, terrainMatrix[row][col]);
            }
        }
        batch.end();
    }

    private void drawTile(int x, int y, int type) {
        final var tile = type == TileType.Grass.ordinal() ? grassTile : dirtTile;
        tile.setPosition(x, y);
        tile.draw(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
        textureGrass.dispose();
        textureDirt.dispose();
    }
}
