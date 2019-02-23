package ValueObjects;

/**
 * Simple class that represents the coordinate in a 2D space.
 * 
 * @author Mbele Lebohang
 * @version 24/2/2015
 */

public class CoordinatesValue {
    public final int xCoordinate;
    public final int yCoordinate;

    public CoordinatesValue(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Create coordinates from the given xCoordinate and yCoordinate value
     */
    public static CoordinatesValue From(int xCoordinate, int yCoordinate){
        return new CoordinatesValue(xCoordinate, yCoordinate);
    }

    @Override
    public String toString(){
        return "(" + this.xCoordinate + ", "+ this.yCoordinate +")";
    }
}