package RoverTypes;

/**
 * @author Mbele Lebohang
 * @version 24/2/2015
 */

/**
 * Enumerator that defines commands that can be understood of a Rover
 */
public enum Command{
    /**
     * Move one space forward in the direction it is facing
     */
    M("MOVE"),
    /**
     * rotate 90 degrees to the right
     */
    R("RIGHT"),
    /**
     * rotate 90 degrees to the left
     */
    L("LEFT");

    public String value;

    Command(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}