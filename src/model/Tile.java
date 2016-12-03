package model;

/**
 * Created by Dende on 03.12.2016.
 */
public class Tile {

    private TileType stoveType;
    private int boneCount;

    public TileType getTileType() {
        return stoveType;
    }

    public void setTileType(TileType stoveType) {
        this.stoveType = stoveType;
    }

    public int getBoneCount() {
        return boneCount;
    }

    public void setBoneCount(int boneCount) {
        this.boneCount = boneCount;
    }
}
