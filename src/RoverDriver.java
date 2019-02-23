import ValueObjects.*;
/**
 * Application driver class
 * 
 * @author Mbele Lebohang 
 * @version 23/2/2019
 */

public class RoverDriver {
    public static void main(String args[]) {
        System.out.println("Mars Rover Challenge by NEXT45");
        CoordinatesValue coords = CoordinatesValue.From(1,2);
        System.out.println(coords.toString());
    }
}
