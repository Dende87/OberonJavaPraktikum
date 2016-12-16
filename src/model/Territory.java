package model;

import javafx.geometry.Pos;

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
    public TileType getTileType(Position position){
        if(position.getRow() < 0 || position.getColumn() < 0 || position.getRow() >= gamefield.length || position.getColumn() >= gamefield.length) return TileType.OUT_OF_FIELD;
        return gamefield[position.getRow()][position.getColumn()].getTileType();
    }

    //Wie viele Knochen sind auf einer Kachel?
    public int getBoneCount(Position position){
        if(getTileType(position)!= TileType.BONE) return 0;
        return gamefield[position.getRow()][position.getColumn()].getBoneCount();
    }

    public boolean boneAvailable(Position position){
        if(getBoneCount(position) > 0){
            return true;
        }
        return false;
    }

    //entferne Knochen von einer Kachel, falls vorhanden
    public boolean removeBoneFromTile(Position position){
        if(!boneAvailable(position)){
            return false;
        }
        gamefield[position.getRow()][position.getColumn()].setBoneCount(getBoneCount(position)-1);
        return true;
    }

    //füge Knochen auf einer Kachel hinzu
    public void addBoneOnTile(Position position){
        gamefield[position.getRow()][position.getColumn()].setBoneCount(getBoneCount(position)+1);
    }

    //Was befindet sich je nach Blickrichtung vor einer Kachel
    public TileType getTileTypeFromNextTileOfDirection(Direction direction, Position position){

        return getTileType(getNextTileFromDirection(direction, position));
    }

    //Gib mir die nächste Position je nach Blickrichtung
    public Position getNextTileFromDirection(Direction direction, Position position) {

        switch (direction) {
            case NORTH:
                position.setRow(position.getRow()-1);
                break;
            case EAST:
                position.setColumn(position.getColumn()+1);
                break;
            case SOUTH:
                position.setRow(position.getRow()+1);
                break;
            case WEST:
                position.setColumn(position.getColumn()-1);
                break;
            default:
                throw new RuntimeException("not implemented Enum: Direction");
        }

        return position;
    }

    //ändere den Typ einer Kachel
    public void changeTileType(Position position, TileType tileType){
        if(getTileType(position)!= TileType.OUT_OF_FIELD) {
            gamefield[position.getRow()][position.getColumn()].setTileType(tileType);
        }
    }

}
