package model;

/**
 * Created by Dende on 03.12.2016.
 */
public class Tile {

    private TileType tileType;
    private int boneCount;

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public int getBoneCount() {
        return boneCount;
    }

    public void setBoneCount(int boneCount) {
        this.boneCount = boneCount;
    }
}
