package nasa.com;

import nasa.com.classes.Coordinate;
import nasa.com.classes.Plateau;
import nasa.com.classes.Position;
import nasa.com.classes.Rover;
import nasa.com.interfaces.IPlateau;
import nasa.com.interfaces.IRover;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please write the size of the plateau(such as 5 5): ");

            Coordinate coordinate = Utils.getCoordinateByParseInput(scanner.nextLine());

            System.out.println("xCoordinate: " + coordinate.getX() + " yCoordinate: " + coordinate.getY());
            IPlateau plateau = new Plateau(coordinate);
            String again;

            do {

                try {
                    System.out.println("Please set new rover's position(X Y Direction): ");
                    Position position = Utils.getPositionByParseInput(scanner.nextLine());
                    IRover rover = new Rover(plateau);
                    rover.setInitPosition(position);

                    System.out.println("Please set rover's instructions(LMR): ");
                    String commands = scanner.next();

                    for (char command : commands.toCharArray()) {
                        // System.out.println(command);
                        rover.move(command);
                    }

                    System.out.println(rover.getPosition().toString());
                } catch (NasaException ex) {
                    ex.printStackTrace();
                }

                System.out.println("Do you want to continue(Y/N)?: ");
                again = scanner.next();

            } while ("y".equals(again.toLowerCase()));


        } catch (NasaException ex) {
            ex.printStackTrace();
        }


    }
}
