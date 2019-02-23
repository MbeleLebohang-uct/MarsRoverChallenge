package Rover;
import RoverTypes.*;
import ValueObjects.*;

/**
 * Simple class that represents the Mars Rover. The Rover has an instance variable that
 * represents the current position and the surface where is moving.
 * 
 * @author Mbele Lebohang
 * @version 24/2/2015
 */
public class Rover {
    private final Surface surface;
    private Position position;

    private Rover(Position position, Surface surface){
        this.position = position;
        this.surface = surface;
    }

    /**
     * Create a Rover with the given surface Dimensions and given initial xCoordinate, yCoordinate and direction
     * @return the Rover
     */
    public static Rover From(int xCoordinate, int yCoordinate, Direction direction, int xDimension, int yDimension){
        Position roverPosition = Position.From(xCoordinate, yCoordinate, direction);
        Surface roverSurface = Surface.From(xDimension, yDimension);

        return new Rover(roverPosition, roverSurface);
    }

    /**
     * Create a Rover with the given surface object and given initial position object
     * @return the Rover
     */
    public static Rover From(Position position, Surface surface){
        return new Rover(position, surface);
    }

    /**
     * @return the position
     */
    public Position getCurrentPosition() {
        return position;
    }

    /**
     * @return the surface
     */
    public Surface getSurface() {
        return surface;
    }
    public boolean equals(Rover rover) {
        return position.equals(rover.getCurrentPosition()) && surface.equals(rover.getSurface());
    }
}
