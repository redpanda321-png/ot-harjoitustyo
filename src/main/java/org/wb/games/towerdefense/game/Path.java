package org.wb.games.towerdefense.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Path {
    TiledMap map;
//    HashMap<Integer, Checkpoint> checkpoints;
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


/*        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 32; x++) {
                if (layer.getCell(x, y) != null) {
                    if ((int) layer.getCell(x, y).getTile().getProperties().get("checkpoint") != 99) {
                        int checkpointNumber = (int) layer.getCell(x, y).getTile().getProperties().get("checkpoint");
                        checkpoints.add(new Checkpoint(x, y, checkpointNumber));
                    }
                }
            }
        }
*/

    }

    public Checkpoint getCheckpoint(int checkpoint) {
        return checkpoints.get(checkpoint);
    }

    public Checkpoint getNextCheckpoint(int checkpoint) {
        if (checkpoint == 99 || checkpoints.get(checkpoint + 1) == null) {
            return checkpoints.get(99);
        }
        return checkpoints.get(checkpoint + 1);
    }

    public float getNextCheckpointX(int checkpoint) {
        if (checkpoint == 99 || checkpoints.get(checkpoint + 1) == null) {
            float c = (float) (checkpoints.get(99).getTileX() * 16);
            return c;
        }
        float d = (float) (checkpoints.get(checkpoint + 1).getTileX() * 16);
        return d;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }
}




