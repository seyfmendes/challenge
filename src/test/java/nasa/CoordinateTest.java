package nasa;

import nasa.com.classes.Coordinate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

    Coordinate notSetXCoordinate;
    Coordinate notSetYCoordinate;
    Coordinate defaultCoordinate;

    @Before
    public void init() {
        notSetXCoordinate = new Coordinate();
        notSetXCoordinate.setY(3);
        notSetYCoordinate = new Coordinate();
        notSetYCoordinate.setX(3);
        defaultCoordinate = new Coordinate();
    }

    @Test
    public void Should_Zero_When_XCoordinateNotSet() {
        Assert.assertEquals(notSetXCoordinate.toString(), "0 3");
    }

    @Test
    public void Should_Zero_When_YCoordinateNotSet() {
        Assert.assertEquals(notSetYCoordinate.toString(), "3 0");
    }

    @Test
    public void Should_Zero_When_XYCoordinateNotSet() {
        Assert.assertEquals(defaultCoordinate.toString(), "0 0");
    }

}
