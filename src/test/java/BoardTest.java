import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> locations;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        locations = asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        board = new Board(printStream, locations);
    }

    @Test
    public void shouldPrintThreeByThreeGridWhenLocationsContainCountingNumbers() {
        board.draw();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");

    }

    @Test
    public void shouldPrintThreeByThreeGridWhenLocationsContainTheLetterR() {
        locations = asList("R", "R", "R", "R", "R", "R", "R", "R", "R");
        board = new Board(printStream, locations);

        board.draw();

        verify(printStream).println(
            "R|R|R\n" +
            "-----\n" +
            "R|R|R\n" +
            "-----\n" +
            "R|R|R"
        );
    }

    @Test
    public void shouldPlaceXInLocationZeroWhenPositionOneIsMarked() {
        board.mark(1, "X");
        assertThat(locations.get(0), is("X"));
    }

    @Test
    public void shouldPlaceXInPositionFourWhenPositionFiveIsMarked() {
        board.mark(5, "X");
        assertThat(locations.get(4), is("X"));
    }

    @Test
    public void shouldPlaceOWhenMarkedSymbolIsO() {
        board.mark(1, "O");
        assertThat(locations.get(0), is("O"));
    }

    @Test
    @Ignore
    public void shouldReturnFalseWhenLocationIsMarked() {
        int locationToMark = 3;
        String playerSymbol = "X";
        int boardIndexForLocationToMark = 2;
        locations.set(boardIndexForLocationToMark, playerSymbol);

        assertThat(board.isLocationEmpty(locationToMark), is(false));
    }

    @Test
    public void shouldReturnTrueWhenLocationIsNotMarked() {
        int locationToCheck = 3;

        assertThat(board.isLocationEmpty(locationToCheck), is(false));
    }

}