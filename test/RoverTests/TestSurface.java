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
import Rover.*;

/*
* JUnit test class for Rover Surface object
*
* @author Mbele Lebohang
* @version 23/02/2019
*/

@RunWith(value = Parameterized.class)
public class TestSurface {
    @Parameter(value = 0)
    public int xDimension;

    @Parameter(value = 1)
    public int yDimension;

    @Parameters(name = "{index}: xDimension = {0}, yDimension = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2},
        });
    }

    // Tests
    @Test
    public void Constructor_ValidInputs_InstanceCreated() {
        // Require 'java -ea' to enable assertions for this part of test. 
		try {
			Surface surface = make_SurfaceWithGivenDimensions(xDimension, yDimension);
		}
		catch (AssertionError assErr) {
			// Test passed.
			return;
		}
    }

    // Factory Methods
    private Surface make_SurfaceWithGivenDimensions(int xDimension,int yDimension){
        return Surface.From(xDimension, yDimension);
    }
}