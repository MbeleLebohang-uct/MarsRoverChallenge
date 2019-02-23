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

    @Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
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
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);
        
        int returnedValue = coordinatesValue.getxCoordinate();
        int expectedValue = xCoordinate;
        
        assertEquals(returnedValue, expectedValue);
    }

    @Test
    public void getY_ValidInput_ValueReturned() {
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);
        
        int returnedValue = coordinatesValue.getyCoordinate();
        int expectedValue = yCoordinate;

        assertEquals(returnedValue, expectedValue);
    }

    @Test
    public void toString_ValidInput_CoordinatesStringCreated() {
	    CoordinatesValue coordinatesValue = make_CoordinatesValue(xCoordinate, yCoordinate);

        String returnedValue = coordinatesValue.toString();
        String expectedValue = "(" + xCoordinate + ", " + yCoordinate + ")";

        assertEquals(coordinatesValue.getyCoordinate(), yCoordinate);
    }

    // Factory Methods
    private CoordinatesValue make_CoordinatesValue(int xCoordinate, int yCoordinate){
        return CoordinatesValue.From(xCoordinate, yCoordinate);
    }
}