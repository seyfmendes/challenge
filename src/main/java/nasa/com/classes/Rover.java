package nasa.com.classes;

import nasa.com.NasaException;
import nasa.com.enums.Direction;
import nasa.com.enums.RoverError;
import nasa.com.interfaces.IPlateau;
import nasa.com.interfaces.IRover;

public class Rover implements IRover {


    private IPlateau plateau;
    private Position position;

    public Rover(IPlateau plateau) {
        this.plateau = plateau;
    }

    /**
     * set rover's initial position
     *
     * @param position
     * @throws NasaException
     */
    public void setInitPosition(Position position) throws NasaException {
        if (plateau.isOutOfArea(position.getCoordinate().getX(), position.getCoordinate().getY()))
            throw new NasaException(RoverError.OUT_OF_AREA_EXCEPTION);
        this.position = position;
    }

    /**
     * Returns rover's position
     *
     * @return
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Rover moves according to the sent character
     *
     * @param command
     * @throws NasaException
     */
    public void move(char command) throws NasaException {

        switch (command) {
            case 'L':
                turnLeft();
                break;
            case 'M':
                goStraight();
                break;
            case 'R':
                turnRight();
        }

    }

    /**
     * Change direction by left command
     */
    private void turnLeft() {
        Direction direction = position.getDirection() != Direction.E ? Direction.values()[position.getDirection().ordinal() - 1] : Direction.N;
        position.setDirection(direction);
    }

    /**
     * Change direction by right command
     */
    private void turnRight() {
        Direction direction = position.getDirection() != Direction.N ? Direction.values()[position.getDirection().ordinal() + 1] : Direction.E;
        position.setDirection(direction);
    }

    /**
     * check it can move
     *
     * @throws NasaException
     */
    private void goStraight() throws NasaException {
        int x = position.getCoordinate().getX();
        int y = position.getCoordinate().getY();

        switch (position.getDirection()) {
            case E:
                x++;
                break;
            case S:
                y--;
                break;
            case W:
                x--;
                break;
            case N:
                y++;
                break;
        }

        if (plateau.isOutOfArea(x, y))
            throw new NasaException(RoverError.OUT_OF_AREA_EXCEPTION);

        position.getCoordinate().setX(x);
        position.getCoordinate().setY(y);

    }

}
