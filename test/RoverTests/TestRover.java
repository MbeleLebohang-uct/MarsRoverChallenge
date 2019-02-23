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
import RoverTypes.*;
import Rover.*;

/*
* JUnit test class for Rover Surface object
*
* @author Mbele Lebohang
* @version 23/02/2019
*/

@RunWith(value = Parameterized.class)
public class TestRover {
    @Parameter(value = 0)
    public int xCoordinate;

    @Parameter(value = 1)
    public int yCoordinate;

    @Parameter(value = 2)
    public int xDimension;

    @Parameter(value = 3)
    public int yDimension;

    @Parameter(value = 4)
    public int direction;

    @Parameters(name = "{index}: xCoordinate = {0}, yCoordinate = {1}, xDimension = {2}, yDimension = {3}, direction = {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 8, 10, Direction.E},
        });
    }

    // Tests
    @Test
    public void Constructor_IntegerValues_InstanceCreated() {
        // Require 'java -ea' to enable assertions for this part of test. 
		try {
			Position position = make_PositionWithIntegerPoints(xCoordinate, yCoordinate, direction);
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
    }

    // Factory Methods
    private Position make_RoverWithIntegerValues(int xCoordinate,int yCoordinate, Direction direction, int xDimension,int yDimension){
        return Rover.From(xCoordinate, yCoordinate, direction, xDimension, yDimension);
    }

    private Position make_RoverWithObjectValues(Position position, Surface surface){
        return Rover.From(position, surface);
    }

    private Position make_PositionWithIntegerPoints(int xCoordinate,int yCoordinate, Direction direction){
        return Position.From(xCoordinate, yCoordinate, direction);
    }

    private Surface make_SurfaceWithGivenDimensions(int xDimension,int yDimension){
        return Surface.From(xDimension, yDimension);
    }

}