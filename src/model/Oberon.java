package model;

/**
 * Created by Dende on 03.12.2016.
 */
public class Oberon {

    private Direction direction;
    private Territory territory;
    private final TileType oberonTileType = TileType.OBERON;
    private int currentRow;
    private int currentColumn;

    //Oberon blickt beim ersten setzen auf dem Spielfeld immer nach Osten
    //Oberon kennt sein Spielfeld
    public Oberon(Territory territory, int row, int column) {
        currentRow = row;
        currentColumn = column;
        this.direction = Direction.EAST;
        this.territory = territory;
    }

    //wo befindet sich Oberon
    //setze Oberon auf Spielfeld
    public void setOberonOnTerritory(int row, int column){
        currentRow = row;
        currentColumn = column;
        territory.changeTileType(row, column, oberonTileType);
    }

    //was liegt vor mir(vor meiner Blickrichtung)
    public TileType getTileTypeFromDirection(){
        return territory.getTileTypeFromNextTileOfDirection(direction, currentRow, currentColumn);
    }

    //nimm Knochen(falls welche vorhanden)
    public void takeBone(){
        territory.removeBoneFromTile(currentRow, currentColumn);
    }

    //lass Knochen fallen(wenn du welche hast)
    public void dropBone(){
        territory.addBoneOnTile(currentRow, currentColumn);
    }

    //vorneFrei
    public boolean isFrontFree(){
        if(getTileTypeFromDirection() != TileType.TREE || getTileTypeFromDirection() != TileType.OUT_OF_FIELD){
            return true;
        }
        return false;
    }

    //geh nach vorne Richtung Blickrichtung(falls es geht)
    public void moveAhead(){
        if(isFrontFree()){
            int newRow = currentRow;
            int newColumn = currentColumn;

            setOberonOnTerritory(territory.getNextTileFromDirection(direction, currentRow, currentColumn)[0],territory.getNextTileFromDirection(direction, currentRow, currentColumn)[1]);
        }
    }

    //wechsel deine Blickrichtung(linksdrehung)
    public void turnLeft(){

        switch (direction){
            case NORTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            default: throw new RuntimeException("not implemented Enum: Direction");
        }

    }
}
