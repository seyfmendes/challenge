package nasa.com;

import nasa.com.classes.Coordinate;
import nasa.com.classes.Position;
import nasa.com.enums.Direction;
import nasa.com.enums.RoverError;

public class Utils {


    public static Coordinate getCoordinateByParseInput(String input) throws NasaException {

        Coordinate coordinate = null;

        try {
            String[] inputs = input.split(" ");
            if (inputs.length != 2)
                throw new Exception();
            coordinate = new Coordinate(Integer.valueOf(inputs[0]), Integer.valueOf(inputs[1]));
        } catch (Exception ex) {
            throw new NasaException(RoverError.PARS_EXCEPTION);
        }
        return coordinate;
    }

    public static Position getPositionByParseInput(String input) throws NasaException {

        Position position = null;

        try {
            String[] inputs = input.split(" ");
            if (inputs.length != 3)
                throw new Exception();
            position = new Position(new Coordinate(Integer.valueOf(inputs[0]), Integer.valueOf(inputs[1])), Direction.valueOf(inputs[2].toUpperCase()));
        } catch (Exception ex) {
            throw new NasaException(RoverError.PARS_EXCEPTION);
        }
        return position;
    }
}
