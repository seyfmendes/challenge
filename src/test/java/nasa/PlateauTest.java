package nasa;


import nasa.com.classes.Coordinate;
import nasa.com.classes.Plateau;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlateauTest {

    Plateau plateau;

    @Before
    public void init() {
        Coordinate coordinate = new Coordinate(5, 5);
        plateau = new Plateau(coordinate);
    }

    @Test
    public void Should_True_When_XCoordinateIsOutOfArea() {
        Assert.assertTrue(plateau.isOutOfArea(6, 3));
    }

    @Test
    public void Should_True_When_YCoordinateIsOutOfArea() {
        Assert.assertTrue(plateau.isOutOfArea(3, 6));
    }


    @Test
    public void Should_False_When_CoordinateIsInArea() {
        Assert.assertFalse(plateau.isOutOfArea(3, 3));
    }


    @Test
    public void Should_True_When_XCoordinateSmallerThanZero() {
        Assert.assertTrue(plateau.isOutOfArea(-1, 3));
    }

    @Test
    public void Should_True_When_YCoordinateSmallerThanZero() {
        Assert.assertTrue(plateau.isOutOfArea(3, -1));
    }

}
