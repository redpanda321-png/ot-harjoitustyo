package org.wb.games.towerdefense.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.wb.games.towerdefense.helpers.FileReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TowerTest {
    @Test
    public void testTowerNotOnLayer() {
        var tile = mock(TiledMapTile.class);
        when(tile.getId()).thenReturn(123);
        var x = 10;
        var y = 10;
        var layer = mock(TiledMapTileLayer.class);
        var tower = Tower.createTower(x, y, layer, tile);
        assertThat(tower).isNotNull();
    }

    @Test
    public void testTowerIsOnLayer() {
        var tile = mock(TiledMapTile.class);
        when(tile.getId()).thenReturn(897);
        var x = 10;
        var y = 10;
        var layer = mock(TiledMapTileLayer.class);
        when(layer.getCell(eq(x), eq(y))).thenReturn(mock(TiledMapTileLayer.Cell.class));
        var tower = Tower.createTower(x, y, layer, tile);
        assertThat(tower).isNull();
    }

    @Test
    public void testShoot() {
        try (MockedStatic<FileReader> reader = Mockito.mockStatic(FileReader.class)) {
            reader.when(FileReader::loadArrow).thenReturn(mock(Texture.class));

            var tile = mock(TiledMapTile.class);
            when(tile.getId()).thenReturn(123);
            var x = 10;
            var y = 10;
            var layer = mock(TiledMapTileLayer.class);
            var tower = Tower.createTower(x, y, layer, tile);
            assertThat(tower).isNotNull();

            var result = tower.shoot(16, 16);

            assertThat(result).isNotNull();
        }
    }

}