package ValueObjectsTests;
import  java.util.Arrays;
import  java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import ValueObjects.*;

/*
* JUnit test class for Coordinates Value object
*
* @author Mbele Lebohang
* @version 23/02/2019
*/

@RunWith(value = Parameterized.class)
public class TestCoordinatesValue {
    @Parameter(value = 0)
    public int xCoordinate;

    @Parameter(value = 1)
    public int yCoordinate;

    @Parameters(name = "{index}: xCoordinate = {0}, yCoordinate = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2},
                {5, 3}
        });
    }

    // Tests
    @Test
    public void Constructor_ValidInput_InstanceCreated() {
        // Require 'java -ea' to enable assertions for this part of test. 
		try {
			CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
    }

    @Test
    public void getX_ValidInput_ValueReturned() {
        // Arrange
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);
        
        // Action
        int returnedValue = coordinatesValue.getxCoordinate();
        int expectedValue = xCoordinate;
        
        // Assert
        assertEquals(returnedValue, expectedValue);
    }

    @Test
    public void getY_ValidInput_ValueReturned() {
        // Arrange 
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);
        
        // Action
        int returnedValue = coordinatesValue.getyCoordinate();
        int expectedValue = yCoordinate;

        // Assert
        assertEquals(returnedValue, expectedValue);
    }

    @Test
    public void toString_ValidInput_CoordinatesStringCreated() {
        // Arrange
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);

        // Action
        String returnedValue = coordinatesValue.toString();
        String expectedValue = "(" + xCoordinate + ", " + yCoordinate + ")";

        // Assert
        assertEquals(returnedValue, expectedValue);
    }

    @Test
    public void equals_ValidInput_CoordinatesEqual() {
        // Arrange
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);
	    CoordinatesValue otherCoordinatesValue = make_CoordinatesValue(2, 7);

        // Action

        // Assert
        assertTrue(!coordinatesValue.equals(otherCoordinatesValue));
    }

    @Test
    public void equals_ValidInput_CoordinatesNotEqual() {
        // Arrange
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);
	    CoordinatesValue otherCoordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);

        // Action

        // Assert
        assertTrue(coordinatesValue.equals(otherCoordinatesValue));
    }

    @Test
    public void incrementX_ValidInput_xCoordinatesIncremented() {
        // Arrange
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);

        // Action
        int newXCoordinate = coordinatesValue.IncrementXCoordinate();
        int expectedXCoordinate = xCoordinate + 1;

        // Assert
        assertEquals(newXCoordinate, expectedXCoordinate);
        assertEquals(coordinatesValue.getxCoordinate(), expectedXCoordinate);
    }

    @Test
    public void incrementY_ValidInput_yCoordinatesIncremented() {
        // Arrange
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);

        // Action
        int newYCoordinate = coordinatesValue.IncrementYCoordinate();
        int expectedYCoordinate = yCoordinate + 1;

        // Assert
        assertEquals(newYCoordinate, expectedYCoordinate);
        assertEquals(coordinatesValue.getyCoordinate(), expectedYCoordinate);
    }

    @Test
    public void decrementX_ValidInput_xCoordinatesIncremented() {
        // Arrange
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);

        // Action
        int newXCoordinate = coordinatesValue.IncrementXCoordinate();
        int expectedXCoordinate = xCoordinate - 1;

        // Assert
        assertEquals(newXCoordinate, expectedXCoordinate);
        assertEquals(coordinatesValue.getxCoordinate(), expectedXCoordinate);
    }

    @Test
    public void decrementY_ValidInput_yCoordinatesIncremented() {
        // Arrange
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);

        // Action
        int newYCoordinate = coordinatesValue.IncrementYCoordinate();
        int expectedYCoordinate = yCoordinate - 1;

        // Assert
        assertEquals(newYCoordinate, expectedYCoordinate);
        assertEquals(coordinatesValue.getyCoordinate(), expectedYCoordinate);
    }

    // Factory Methods
    private CoordinatesValue make_CoordinatesValue(int xCoordinate, int yCoordinate){
        return CoordinatesValue.From(xCoordinate, yCoordinate);
    }
}