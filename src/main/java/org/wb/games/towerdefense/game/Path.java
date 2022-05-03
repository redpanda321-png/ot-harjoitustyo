package org.wb.games.towerdefense.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.List;

public class Path {
    TiledMap map;
    private List<Checkpoint> checkpoints;
    TiledMapTileLayer layer;

    public Path(TiledMap map) {
        this.map = map;
        checkpoints = List.of(
                new Checkpoint(4, 19, 1),
                new Checkpoint(15, 19, 2),
                new Checkpoint(15, 13, 3),
                new Checkpoint(5, 13, 4),
                new Checkpoint(5, 4, 5),
                new Checkpoint(27, 4, 6),
                new Checkpoint(27, 11, 7),
                new Checkpoint(22, 11, 8),
                new Checkpoint(22, 24, 9),
                new Checkpoint(15, 24, 10),
                new Checkpoint(15, 30, 11)
        );

        this.layer = (TiledMapTileLayer) map.getLayers().get("Checkpoints");

    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }
}




