package nasa;

import nasa.com.NasaException;
import nasa.com.classes.Coordinate;
import nasa.com.classes.Plateau;
import nasa.com.classes.Position;
import nasa.com.classes.Rover;
import nasa.com.enums.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoverTest {

    private Plateau plateau;
    private Rover rover;

    @Before
    public void init() {
        plateau = new Plateau(new Coordinate(5, 5));
        rover = new Rover(plateau);
    }

    @Test(expected = NasaException.class)
    public void Should_ThrowsError_When_CoordinateOutOfArea() throws NasaException {
        Position position = new Position(new Coordinate(10, 10), Direction.E);
        rover.setInitPosition(position);
    }

    @Test
    public void Should_TurnWest_When_LCommandReceivedNorthPosition() throws NasaException {
        Position position = new Position(new Coordinate(2, 2), Direction.N);
        rover.setInitPosition(position);

        rover.move('L');
        Assert.assertEquals(Direction.W, rover.getPosition().getDirection());
    }

    @Test
    public void Should_TurnEast_When_RCommandReceivedNorthPosition() throws NasaException {
        Position position = new Position(new Coordinate(2, 2), Direction.N);
        rover.setInitPosition(position);

        rover.move('R');
        Assert.assertEquals(Direction.E, rover.getPosition().getDirection());
    }

    @Test
    public void Should_YCoordinateIncrease_When_MCommandReceivedNorthPosition() throws NasaException {
        Position position = new Position(new Coordinate(2, 2), Direction.N);
        rover.setInitPosition(position);

        rover.move('M');
        Assert.assertEquals(3, rover.getPosition().getCoordinate().getY());
    }

    @Test
    public void Should_YCoordinateDecrease_When_MCommandReceivedSouthPosition() throws NasaException {
        Position position = new Position(new Coordinate(2, 2), Direction.S);
        rover.setInitPosition(position);

        rover.move('M');
        Assert.assertEquals(1, rover.getPosition().getCoordinate().getY());
    }

    @Test
    public void Should_XCoordinateIncrease_When_MCommandReceivedEastPosition() throws NasaException {
        Position position = new Position(new Coordinate(2, 2), Direction.E);
        rover.setInitPosition(position);

        rover.move('M');
        Assert.assertEquals(3, rover.getPosition().getCoordinate().getX());
    }

    @Test
    public void Should_XCoordinateDecrease_When_MCommandReceivedWestPosition() throws NasaException {
        Position position = new Position(new Coordinate(2, 2), Direction.W);
        rover.setInitPosition(position);

        rover.move('M');
        Assert.assertEquals(1, rover.getPosition().getCoordinate().getX());
    }


    @Test(expected = NasaException.class)
    public void Should_ThrowsError_When_MCommandReceivedCoordinateOutOfArea() throws NasaException {
        Position position = new Position(new Coordinate(5, 5), Direction.E);
        rover.setInitPosition(position);
        rover.move('M');
    }

}
