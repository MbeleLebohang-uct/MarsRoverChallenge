import ValueObjects.*;
import RoverTypes.*;
import Rover.*;
/**
 * Application driver class
 * 
 * @author Mbele Lebohang 
 * @version 23/2/2019
 */

public class RoverDriver {
    public static void main(String args[]) {
        System.out.println("Mars Rover Challenge by NEXT45");
        String commandString = "MMLMRMMRRMML";

        for(String command : commandString.split("")){
            System.out.println(command);
        }
    }
}
