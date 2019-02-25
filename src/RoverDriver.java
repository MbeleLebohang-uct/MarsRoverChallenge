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

        Surface surface = null;
        Position position = null;
        Command[] commands = null;

        boolean notEnoughArguments = args.length != 9;
        if(notEnoughArguments){
            System.out.println("IncorrectArguments: The arguments passes are incorrect. Please look at README file.");
            System.out.println("System Exit(0)");
            System.exit(0);
        }


        for(int i = 0; i < args.length; i++){
            if(args[i].charAt(0) == '-'){                
                switch (args[i]){
                    case "-s":
                        surface = decodeSurface(args[i + 1], args[i + 2]);
                        break;
                    case "-c":
                        commands = DecodeCommands(args[i + 1]);
                        break;
                    case "-p":
                        position = decodePosition(args[i + 1], args[i + 2], args[i + 3]);
                        break;
                    default:
                        System.out.println("UnknownFlagException: The driver does not understand flag "+ args[i] + ". Please look at README file.");
                        System.out.println("System Exit(0)");
                        System.exit(0);
                }
                continue;
            }
        }

        Rover rover = Rover.From(position, surface);
        System.out.println("============= Rover Successully Running =============");
        System.out.println("Rover Initial Position: " + rover.getCurrentPosition().toString());
        System.out.println("Survey Surface Dimensions: " + rover.getSurface().toString());
        System.out.println();

        System.out.println("============= Rover Executing Commands =============");
        rover.ExecuteCommands(commands);
        System.out.println();

        System.out.println("============= Commands Executed Successfully =============");
        System.out.println("Rover Current Position: " + rover.getCurrentPosition().toString());
    }

    private static Surface decodeSurface(String xDimension, String yDimension){
        boolean incorrectSurfaceArguments = xDimension.charAt(0) == '-' || yDimension.charAt(0) == '-';
        boolean nonIntegerArguments = !isInteger(xDimension) || !isInteger(yDimension);

        if(incorrectSurfaceArguments || nonIntegerArguments){
            System.out.println("IncorrectSurfaceArguments: The arguments (" + xDimension +", "+ yDimension + ") passes are incorrect. Please look at README file.");
            System.out.println("System Exit(0)");
            System.exit(0);
        }

        return Surface.From(Integer.parseInt(xDimension), Integer.parseInt(yDimension));
    }

    private static Position decodePosition(String xCoordinate, String yCoordinate, String pDirection){
        boolean incorrectSurfaceArguments = xCoordinate.charAt(0) == '-' || yCoordinate.charAt(0) == '-';
        boolean nonIntegerArguments = !isInteger(xCoordinate) || !isInteger(yCoordinate);
        boolean unknownDirection = !"NSEW".contains(pDirection);

        if(incorrectSurfaceArguments || nonIntegerArguments || unknownDirection){
            System.out.println("IncorrectPositionArguments: The arguments (" + xCoordinate +", "+ yCoordinate + ", "+ pDirection +") passes are incorrect. Please look at README file.");
            System.out.println("System Exit(0)");
            System.exit(0);
        }
        Direction direction = Direction.valueOf(pDirection);

        return Position.From(Integer.parseInt(xCoordinate), Integer.parseInt(yCoordinate), direction);
    }

    private static Command[] DecodeCommands(String pCommands){
        Command[] commandList = new Command[pCommands.length()];
        String[] commands = pCommands.split("");

        for(int i = 0; i < commands.length; i++){
            boolean unknownCommand = !"MRL".contains(commands[i]);

            if(unknownCommand){
                System.out.println("UnknownCommand: The Rover does not understand command " + commands[i] + ". Please look at challenge pdf.");
                System.out.println("System Exit(0)");
                System.exit(0);
            }
            commandList[i] = Command.valueOf(commands[i]);
        }

        return commandList;
    }

    public static boolean isInteger(String str)  
    {  
        try  
        {  
            Integer.parseInt(str);  
        }  
        catch(NumberFormatException e)  
        {  
            return false;  
        }  
        return true;  
    }
}
