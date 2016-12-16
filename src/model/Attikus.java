package model;

/**
 * Created by Dende on 03.12.2016.
 */
public class Attikus {

    private Territory territory;
    private final TileType attikusTileType = TileType.ATTIKUS;
    private Position position;

    //Attikus kennt sein Spielfeld
    public Attikus(Territory territory, Position position) {
        this.position = position;
        this.territory = territory;
    }

    //wo befindet sich Attikus
    public Position getAttikusPosition(){
        return position;
    }

    //setze Attikus auf Spielfeld
    public void setAttikusOnTerritory(Position position){
        this.position = position;
        territory.changeTileType(position, attikusTileType);
    }
}
