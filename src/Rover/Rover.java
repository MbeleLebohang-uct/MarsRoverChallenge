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
        boolean xCoordinateOutOfBounds = xCoordinate >= xDimension;
        boolean yCoordinateOutOfBounds = yCoordinate >= yDimension;
        if(xCoordinateOutOfBounds){
            System.out.println("xCoordinateOutOfBoundsException: The xCoordinate is outside the surveying surface. Setting xCoordinate to max possible value.");
            xCoordinate = xDimension - 1;
        }

        if(yCoordinateOutOfBounds){
            System.out.println("yCoordinateOutOfBoundsException: The yCoordinate is outside the surveying surface. Setting yCoordinate to max possible value.");
            yCoordinate = yDimension - 1;
        }

        Position roverPosition = Position.From(xCoordinate, yCoordinate, direction);
        Surface roverSurface = Surface.From(xDimension, yDimension);

        return new Rover(roverPosition, roverSurface);
    }

    /**
     * Create a Rover with the given surface object and given initial position object
     * @return the Rover
     */
    public static Rover From(Position position, Surface surface){
        return Rover.From(position.getCurrentCoordinates().getxCoordinate(), position.getCurrentCoordinates().getyCoordinate(), position.getCurrentDirection(), surface.getxDimension(), surface.getyDimension());
    }

    /**
     * Execute the given list of commands and return the new position after command execution
     * @return new position
     */
    public Position ExecuteCommands(Command[] commands){
        System.out.println();
        for(Command command : commands){
            position.Move(command, surface);
        }
        return this.position;
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
