package ValueObjects;

/**
 * Simple class that represents the coordinate in a 2D space.
 * 
 * @author Mbele Lebohang
 * @version 24/2/2015
 */

public class CoordinatesValue {
    private final int xCoordinate;
    private final int yCoordinate;

    public CoordinatesValue(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Create coordinates from the given xCoordinate and yCoordinate value
     * @return the CoordinateValue Object
     */
    public static CoordinatesValue From(int xCoordinate, int yCoordinate){
        return new CoordinatesValue(xCoordinate, yCoordinate);
    }

    /**
     * @return the xCoordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
     * @return the yCoordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public String toString(){
        return "(" + this.xCoordinate + ", "+ this.yCoordinate +")";
    }
}