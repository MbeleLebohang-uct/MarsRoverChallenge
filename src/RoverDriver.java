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
        Position pos = Position.From(1, 2, Direction.E);
        System.out.println(pos.toString());
        Position newPos = pos.Move(Command.M);
        System.out.println(newPos.toString());
        newPos = pos.Move(Command.L);
        System.out.println(newPos.toString());
        newPos = pos.Move(Command.R);
        System.out.println(newPos.toString());
    }
}
