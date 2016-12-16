package model;

/**
 * Created by Dende on 03.12.2016.
 */
public class Oberon {

    private Direction direction;
    private Territory territory;
    private final TileType oberonTileType = TileType.OBERON;
    private Position position;
    private int countBone;

    //Oberon blickt beim ersten setzen auf dem Spielfeld immer nach Osten
    //Oberon kennt sein Spielfeld
    public Oberon(Territory territory, Position position) {
        this.position = position;
        this.direction = Direction.EAST;
        this.territory = territory;
        this.countBone = 0;
    }

    //wo befindet sich Oberon
    public Position getOberonPosition(){
        return position;
    }

    //setze Oberon auf Spielfeld
    public void setOberonOnTerritory(Position position){
        this.position = position;
        territory.changeTileType(position, oberonTileType);
    }

    //was liegt vor mir(vor meiner Blickrichtung)
    public TileType getTileTypeFromDirection(){
        return territory.getTileTypeFromNextTileOfDirection(direction, position);
    }

    //nimm Knochen(falls welche vorhanden)
    public boolean takeBone(){
        if(territory.removeBoneFromTile(position)){
            this.countBone++;
            return true;
        }
        return false;
    }

    //lass Knochen fallen(wenn du welche hast)
    public boolean dropBone(){
        if(this.countBone > 0){
            this.countBone--;
            territory.addBoneOnTile(position);
            return true;
        }
        return false;
    }

    public boolean mawEmpty(){
        if(this.countBone > 0){
            return false;
        }
        return true;
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
            setOberonOnTerritory(territory.getNextTileFromDirection(direction, position));
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
