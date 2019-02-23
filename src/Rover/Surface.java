package Rover;

/**
 * Simple class that represents the surface where the Rover will be moving.
 * 
 * @author Mbele Lebohang
 * @version 24/2/2015
 */

public class Surface {
    private final int xDimension;
    private final int yDimension;

    private Surface(int xDimension, int yDimension){
        this.xDimension = xDimension;
        this.yDimension = yDimension;
    }

    /**
     * Create a surface with given dimentions where the Rover will be moving
     * @return Surface
     */
    public static Surface From(int xDimension, int yDimension){
        return new Surface(xDimension, yDimension);
    }

    /**
     * @return the xDimension
     */
    public int getxDimension() {
        return xDimension;
    }

    /**
     * @return the yDimension
     */
    public int getyDimension() {
        return yDimension;
    }

    @Override
    public String toString() {
        return "["+ "xDimension: " + xDimension + " - yDimension: " + yDimension +"]";
    }

    public boolean equals(Surface surface) {
        return xDimension == surface.getxDimension()  && yDimension == surface.getyDimension();
    }
}