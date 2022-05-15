package org.wb.games.towerdefense.game;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PathTest {

    @Test
    public void testCreatePath() {
        final TiledMap map = mock(TiledMap.class);
        final MapLayers layers = mock(MapLayers.class);
        when(map.getLayers()).thenReturn(layers);
        when(layers.get(anyString())).thenReturn(mock(TiledMapTileLayer.class));

        final Path result = new Path(map);

        assertThat(result).isNotNull();
        assertThat(result.getCheckpoints()).hasSize(11);
    }

}