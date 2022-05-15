package org.wb.games.towerdefense.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.List;

public class Path {
    TiledMap map;
    private final List<Checkpoint> checkpoints;
    TiledMapTileLayer layer;

    public Path(TiledMap map) {
        this.map = map;
        checkpoints = List.of(
                new Checkpoint(4, 19),
                new Checkpoint(15, 19),
                new Checkpoint(15, 13),
                new Checkpoint(5, 13),
                new Checkpoint(5, 4),
                new Checkpoint(27, 4),
                new Checkpoint(27, 11),
                new Checkpoint(22, 11),
                new Checkpoint(22, 24),
                new Checkpoint(15, 24),
                new Checkpoint(15, 30)
        );

        this.layer = (TiledMapTileLayer) map.getLayers().get("Checkpoints");

    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }
}




