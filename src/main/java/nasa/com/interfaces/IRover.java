package nasa.com.interfaces;

import nasa.com.NasaException;
import nasa.com.classes.Position;

public interface IRover {

    void setInitPosition(Position position) throws NasaException;

    Position getPosition();

    void move(char command) throws NasaException;

}
