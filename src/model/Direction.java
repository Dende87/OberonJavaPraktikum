package model;

/**
 * Created by Dende on 03.12.2016.
 */
public enum Direction {

    NORTH,
    EAST,
    SOUTH,
    WEST

    //iteration durch Enums Quelle: http://stackoverflow.com/questions/17664445/is-there-an-increment-operator-for-java-enum
            /*{
        @Override
        public Direction next() {
            return null; // see below for options for this line
        }
    };
    public Direction next() {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + 1];
    }*/
}
