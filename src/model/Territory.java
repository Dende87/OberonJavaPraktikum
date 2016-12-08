package model;

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * Created by Dende on 03.12.2016.
 */
public class Territory {

    //hat Kacheln
    private Tile[][] gamefield;

    public Territory(int rows, int columns){
        this.gamefield = new Tile[rows][columns];
    }

    //was ist auf einer Kachel?
    //Sind Knochen auf einer Kachel?
    public TileType getTileType(int row, int column){
        if(row < 0 || column < 0 || row >= gamefield.length || column >= gamefield.length) return TileType.OUT_OF_FIELD;
        return gamefield[row][column].getTileType();
    }

    //Wie viele Knochen sind auf einer Kachel?
    public int getBoneCount(int row, int column){
        if(getTileType(row,column)!= TileType.BONE) return 0;
        return gamefield[row][column].getBoneCount();
    }

    //entferne Knochen von einer Kachel, falls vorhanden
    public void removeBoneFromTile(int row, int column){
        gamefield[row][column].setBoneCount(getBoneCount(row,column) == 0 ? 0: getBoneCount(row,column)-1);
    }

    //füge Knochen auf einer Kachel hinzu
    public void addBoneOnTile(int row, int column){
        gamefield[row][column].setBoneCount(getBoneCount(row, column)+1);
    }

    //Was befindet sich je nach Blickrichtung vor einer Kachel
    public TileType getTileTypeFromNextTileOfDirection(Direction direction, int row, int column){

        int newRow = getNextTileFromDirection(direction, row, column)[0]; // 0 = Row
        int newColumn = getNextTileFromDirection(direction, row, column)[1]; // 1 = Column

        return getTileType(newRow,newColumn);
    }

    public int[] getNextTileFromDirection(Direction direction, int row, int column) {

        int[] position = new int[2];
        int newRow = row;
        int newColumn = column;

        switch (direction) {
            case NORTH:
                newRow--;
                break;
            case EAST:
                newColumn++;
                break;
            case SOUTH:
                newRow++;
                break;
            case WEST:
                newColumn--;
                break;
            default:
                throw new RuntimeException("not implemented Enum: Direction");
        }
        position[0] = newRow;
        position[1] = newColumn;

        return position;
    }

    //ändere den Typ einer Kachel
    public void changeTileType(int row, int column, TileType tileType){
        if(getTileType(row, column)!= TileType.OUT_OF_FIELD) {
            gamefield[row][column].setTileType(tileType);
        }
    }

}
