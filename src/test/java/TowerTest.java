
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import org.junit.Test;

import org.wb.games.towerdefense.game.Tower;

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

}