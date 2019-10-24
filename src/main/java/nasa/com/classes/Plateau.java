package nasa.com.classes;

import nasa.com.interfaces.IPlateau;

/**
 * This plateau has lower-left coordinates and upper-right coordinates
 */
public class Plateau implements IPlateau {

    private Coordinate coordinate;

    public Plateau() {
    }

    public Plateau(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * values are between 0 and maximum coordinate values
     *
     * @param x xCoordinate
     * @param y yCoordinate
     * @return
     */
    public boolean isOutOfArea(int x, int y) {
        if (x < 0 || y < 0)
            return true;

        if (x > coordinate.getX() || y > coordinate.getY())
            return true;

        return false;
    }
}
