package Rover;
import ValueObjects.*;
import RoverTypes.*;

/**
 * Simple class that represents the position of the Mars Rover.
 * 
 * @author Mbele Lebohang
 * @version 24/2/2015
 */

 public class Position {
    private CoordinatesValue coordinatesValue;
    private Direction direction;

    private Position(CoordinatesValue coordinatesValue, Direction direction){
        this.coordinatesValue = coordinatesValue;
        this.direction = direction;
    }

    /**
     * Create a Rover Position from the given xCoordinate, yCoordinate and Direction
     * @return the Position object
     */
    public static Position From(int xCoordinate, int yCoordinate, Direction direction){
        CoordinatesValue coordinatesValue = CoordinatesValue.From(xCoordinate, yCoordinate);
        return new Position(coordinatesValue, direction);
    }

    /**
     * Create a Rover Position from the given CoordinateValue and Direction
     * @return the Position object
     */
    public static Position From(CoordinatesValue coordinatesValue, Direction direction){
        return new Position(coordinatesValue, direction);
    }

    /**
     * Move from the current position to a new position based on the given command
     * @return new Position after moving
     */
    public Position Move(Command command){
        return null;
    }

    /**
     * Get the current coordinates value of this position
     * @return the coordinatesValue
     */
    public CoordinatesValue getCurrentCoordinates() {
        return coordinatesValue;
    }

    /**
     * Get the current direction value of this position
     * @return the direction
     */
    public Direction getCurrentDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return this.coordinatesValue.toString() + " - " + direction.toString();
    }

    public boolean equals(Position position) {
        return coordinatesValue.equals(position.getCurrentCoordinates()) && direction.equals(position.getCurrentDirection());
    }
 }