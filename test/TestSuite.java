import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ValueObjectsTests.*;
import RoverTests.*;

/**
 * Test class agregator.
 *
 * @author Mbele Lebohang
 * @version 23/2/2019
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TestCoordinatesValue.class, TestPosition.class, TestSurface.class /* , <next class>, <next class>, ... */
})

public class TestSuite {/* Holder for above annotations. */}