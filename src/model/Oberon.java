package model;

/**
 * Created by Dende on 03.12.2016.
 */
public class Oberon {

    private Direction direction;
    private Territory territory;

    //Oberon blickt beim ersten setzen auf dem Spielfeld immer nach Osten
    //Oberon kennt sein Spielfeld
    public Oberon(Territory territory) {
        this.direction = Direction.EAST;
        this.territory = territory;
    }

    //wo befindet sich Oberon
    //setze Oberon auf Spielfeld
    //was liegt vor mir(vor meiner Blickrichtung)
    //nimm Knochen(falls welche vorhanden)
    //lass Knochen fallen(wenn du welche hast)
    //geh nach vorne Richtung Blickrichtung(falls es geht)

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
