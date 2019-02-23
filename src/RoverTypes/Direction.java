package RoverTypes;

/**
 * @author Mbele Lebohang
 * @version 24/2/2015
 */

/**
 * Enumerator that defines 4 possible directions of a Rover
 */
public enum Direction{
    /**
     * North
     */
    N("NORTH"),
    /**
     * East
     */
    E("EAST"),
    /**
     * South
     */
    S("SOUTH"),
    /**
     * West
     */
    W("WEST");

    public String value;

    Direction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean equals(Direction direction) {
        return this.value.equals(direction.value);
    }
}