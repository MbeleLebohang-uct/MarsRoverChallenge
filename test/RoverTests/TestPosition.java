package RoverTests;
import  java.util.Arrays;
import  java.util.Collection;
//
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;
//
import ValueObjects.*;
import RoverTypes.*;
import Rover.*;

/*
* JUnit test class for Rover Position object
*
* @author Mbele Lebohang
* @version 23/02/2019
*/

@RunWith(value = Parameterized.class)
public class TestPosition {
    @Parameter(value = 0)
    public int xCoordinate;

    @Parameter(value = 1)
    public int yCoordinate;

    @Parameter(value = 2)
    public Direction direction;

    @Parameters(name = "{index}: xCoordinate = {0}, yCoordinate = {1}, direction = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, Direction.E},
        });
    }

    // Tests
    @Test
    public void Constructor_CoordinatesValue_InstanceCreated() {
        // Require 'java -ea' to enable assertions for this part of test. 
		try {
            CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);
			Position position = make_PositionWithCoordinatesValue(coordinatesValue, direction);
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
    }

    @Test
    public void Constructor_IntegerPoints_InstanceCreated() {
        // Require 'java -ea' to enable assertions for this part of test. 
		try {
			Position position = make_PositionWithIntegerPoints(xCoordinate, yCoordinate, direction);
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
    }

    @Test
    public void Move_CommandM_MovedToNewPosition() {
        // Arrange
        Position currentPosition = make_PositionWithIntegerPoints(xCoordinate, yCoordinate, direction);
        Command command = Command.M;

        // Action
        Position newPosition = currentPosition.Move(command);
        Position expectedPosition = make_PositionWithIntegerPoints(xCoordinate + 1, yCoordinate, direction);

        // Assert
        assertTrue(newPosition.equals(expectedPosition));
    }

    @Test
    public void Move_CommandL_PositionCHangedDirection() {
        // Arrange
        Position currentPosition = make_PositionWithIntegerPoints(xCoordinate, yCoordinate, direction);
        Command command = Command.L;

        // Action
        Position newPosition = currentPosition.Move(command);
        Position expectedPosition = make_PositionWithIntegerPoints(xCoordinate, yCoordinate, Direction.N);

        // Assert
        assertTrue(newPosition.equals(expectedPosition));
    }

    @Test
    public void Move_CommandR_PositionCHangedDirection() {
        // Arrange
        Position currentPosition = make_PositionWithIntegerPoints(xCoordinate, yCoordinate, direction);
        Command command = Command.R;

        // Action
        Position newPosition = currentPosition.Move(command);
        Position expectedPosition = make_PositionWithIntegerPoints(xCoordinate, yCoordinate, Direction.S);

        // Assert
        assertTrue(newPosition.equals(expectedPosition));
    }

    // Factory Methods
    private Position make_PositionWithIntegerPoints(int xCoordinate,int yCoordinate, Direction direction){
        return Position.From(xCoordinate, yCoordinate, direction);
    }
    private Position make_PositionWithCoordinatesValue(CoordinatesValue coordinates, Direction direction){
        return Position.From(coordinates, direction);
    }

    private CoordinatesValue make_CoordinatesValue(int xCoordinate, int yCoordinate){
        return CoordinatesValue.From(xCoordinate, yCoordinate);
    }
}