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
 }