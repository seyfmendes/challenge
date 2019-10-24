package nasa;

import nasa.com.classes.Coordinate;
import nasa.com.classes.Position;
import nasa.com.enums.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositionTest {

    Coordinate notSetXCoordinate;
    Coordinate notSetYCoordinate;

    @Before
    public void init() {
        notSetXCoordinate = new Coordinate();
        notSetXCoordinate.setY(2);
        notSetYCoordinate = new Coordinate();
        notSetYCoordinate.setX(2);
    }


    @Test
    public void Should_WriteZero_When_XCoordinateNotSet() {
        Position position = new Position(notSetXCoordinate, Direction.E);
        Assert.assertEquals(position.toString(), "0 2 E");
    }

    @Test
    public void Should_WriteZero_When_YCoordinateNotSet() {
        Position position = new Position(notSetYCoordinate, Direction.E);
        Assert.assertEquals(position.toString(), "2 0 E");
    }

    @Test
    public void Should_WriteZero_When_XYCoordinateNotSet() {
        Position position = new Position(new Coordinate(), Direction.E);
        Assert.assertEquals(position.toString(), "0 0 E");
    }

    @Test
    public void Should_WriteNull_When_DirectionIsNull() {
        Position position = new Position(new Coordinate(2, 2));
        Assert.assertEquals(position.toString(), "2 2 null");
    }

}
