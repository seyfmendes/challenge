package nasa;

import nasa.com.NasaException;
import nasa.com.Utils;
import nasa.com.classes.Coordinate;
import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {


    @Test(expected = NasaException.class)
    public void Should_ThrowException_When_InputIsNull() throws NasaException {
        Utils.getCoordinateByParseInput(null);
    }

    @Test(expected = NasaException.class)
    public void Should_ThrowException_When_InputHasNotSpace() throws NasaException {
        Utils.getCoordinateByParseInput("555");
    }

    @Test(expected = NasaException.class)
    public void Should_ThrowException_When_InputHasMultiSpace() throws NasaException {
        Utils.getCoordinateByParseInput("4 4 4 4");
    }

    @Test(expected = NasaException.class)
    public void Should_ThrowException_When_InputHasChar() throws NasaException {
        Utils.getCoordinateByParseInput("4 X");
    }

    @Test
    public void Should_CreatedCoordinate_When_InputIsCorrect() throws NasaException {
        Coordinate coordinate = Utils.getCoordinateByParseInput("4 4");
        Assert.assertEquals(4, coordinate.getX());
    }


    @Test(expected = NasaException.class)
    public void Should_ThrowException_When_PositionInputHasNotSpace() throws NasaException {
        Utils.getPositionByParseInput("22");
    }

    @Test(expected = NasaException.class)
    public void Should_ThrowException_When_PositionCoordinateInputHasChar() throws NasaException {
        Utils.getPositionByParseInput("2 S S");
    }

    @Test(expected = NasaException.class)
    public void Should_ThrowException_When_DirectionOfPositionInputIncorrect() throws NasaException {
        Utils.getPositionByParseInput("2 2 M");
    }

    @Test
    public void Should_CreatedPosition_When_InputIsCorrect() throws NasaException {
        Utils.getPositionByParseInput("2 2 E");
    }
}
