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
     * Move from the current position on the given surface to a new position based on the given command
     * @return new Position after moving
     */
    public Position Move(Command command, Surface surface){
        switch(command){
            case M:
                MoveForward(surface);
                break;

            case R:
                RotateRight();
                break;

            case L:
                RotateLeft();
                break;
        }
        return Position.From(coordinatesValue.getxCoordinate(), coordinatesValue.getyCoordinate(), direction);
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

    /**
     * Helper method to move the rover forward on a given surface based on the current direction in which the Rover is facing
     * @return Void
     */
    private void MoveForward(Surface surface){
        switch (direction){
            case S:
                if(coordinatesValue.getyCoordinate() - 1 < 0){
                    // Idealy this should throw an exception, telling the user that they are moving out of range
                    System.out.println("SurfaceBoundryException: Lower surface bound reached. Rover cannot move forward. Position{"+this.toString()+"}");
                    break;
                }
                coordinatesValue = CoordinatesValue.From(coordinatesValue.getxCoordinate(), coordinatesValue.getyCoordinate() - 1);
                break;

            case N:
                if(coordinatesValue.getyCoordinate() + 1 >= surface.getyDimension()){
                    // Idealy this should throw an exception, telling the user that they are moving out of range
                    System.out.println("SurfaceBoundryException: Upper surface bound reached. Rover cannot move forward. Position{"+this.toString()+"}");
                    break;
                }
                coordinatesValue = CoordinatesValue.From(coordinatesValue.getxCoordinate(), coordinatesValue.getyCoordinate() + 1);
                break;
            
            case E:
                if(coordinatesValue.getxCoordinate() + 1 >= surface.getxDimension()){
                    // Idealy this should throw an exception, telling the user that they are moving out of range
                    System.out.println("SurfaceBoundryException: Right surface bound reached. Rover cannot move forward. Position{"+this.toString()+"}");
                    break;
                }
                coordinatesValue = CoordinatesValue.From(coordinatesValue.getxCoordinate() + 1, coordinatesValue.getyCoordinate());
                break;
            case W:
                if(coordinatesValue.getxCoordinate() - 1 < 0){
                    System.out.println("SurfaceBoundryException: Left surface bound reached. Rover cannot move forward. Position{"+this.toString()+"}");
                    // Idealy this should throw an exception, telling the user that they are moving out of range
                    break;
                }
                coordinatesValue = CoordinatesValue.From(coordinatesValue.getxCoordinate() - 1, coordinatesValue.getyCoordinate());
                break;
        }
    }

    /**
     * Helper method to rotate 90 degrees to the right
     * @return Void
     */
    private void RotateRight(){
        switch (direction){
            case S:
                direction = Direction.W;
                break;

            case N:
                direction = Direction.E;
                break;
            
            case E:
                direction = Direction.S;
                break;
            case W:
                direction = Direction.N;
                break;
        }
    }

    /**
     * Helper method to rotate 90 degrees to the left
     * @return Void
     */
    private void RotateLeft(){
        switch (direction){
            case S:
                direction = Direction.E;
                break;

            case N:
                direction = Direction.W;
                break;
            
            case E:
                direction = Direction.N;
                break;

            case W:
                direction = Direction.S;
                break;
        }
    }
 }