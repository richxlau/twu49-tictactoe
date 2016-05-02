import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class PlayerTest {


    private Player player;
    private PrintStream printStream;
    private Board board;
    private BufferedReader bufferedReader;
    private String defaultSymbol;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("-999");
        board = mock(Board.class);
        when(board.isLocationEmpty(anyInt())).thenReturn(true);
        defaultSymbol = "X";
        player = new Player(printStream, bufferedReader, board, "1", defaultSymbol);
    }

    @Test
    public void shouldPromptFirstPlayerWhenStarting() {
        String playerName = "NameOfPlayer";
        player = new Player(printStream, bufferedReader, board, playerName, "O");

        player.move();

        verify(printStream).println(contains("enter move"));
        verify(printStream).println(contains("Player NameOfPlayer"));
    }

    @Test
    public void shouldMarkBoardWherePlayerMovedWhenPlayerMovedInPositionFive() throws IOException {
        when(bufferedReader.readLine()).thenReturn("5");

        player.move();

        verify(board).mark(5, defaultSymbol);
    }

    @Test
    public void shouldMarkBoardWherePlayerMovedWhenPlayerMovedInPositionTwo() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");

        player.move();

        verify(board).mark(2, defaultSymbol);
    }

    @Test
    public void shouldMarkBoardWithMySymbol() {
        String symbol = "O";
        player = new Player(printStream, bufferedReader, board, "playerName", symbol);

        player.move();

        verify(board).mark(anyInt(), eq(symbol));
    }


    @Test
    public void shouldInformPlayerWhenMovingInAlreadyTakenLocation() {
        when(board.isLocationEmpty(anyInt()))
                .thenReturn(false)
                .thenReturn(true);

        player.move();

        verify(printStream).println("Location already taken");
    }

//    @Test
//    public void shouldNotMarkLocationWhenLocationIsAlreadyTaken() {
//        when(board.isLocationEmpty(anyInt())).thenReturn(false);
//
//        player.move();
//
//        verify(board, never()).mark(anyInt(), anyString());
//    }

    @Test
    public void shouldMarkBoardOnceWhenLocationEnteredIsInvalidAndThenValid() throws IOException {
        when(board.isLocationEmpty(anyInt())).thenReturn(false, true);
        int locationThatIsMarked = 3;
        int locationThatIsNotMarked = 4;
        when(bufferedReader.readLine())
                .thenReturn(Integer.toString(locationThatIsMarked))
                .thenReturn(Integer.toString(locationThatIsNotMarked));

        player.move();

        verify(board, times(1)).mark(eq(locationThatIsNotMarked), anyString());
    }



    @Test
    public void shouldNotInformPlayerWhenMovingInAvailableLocation() {
        when(board.isLocationEmpty(anyInt())).thenReturn(true);

        player.move();

        verify(printStream, never()).println("Location already taken");
    }

    @Test
    public void shouldPromptUserRepeatedlyUntilUnmarkedLocationSelected() {
        when(board.isLocationEmpty(anyInt())).thenReturn(false).thenReturn(true);

        player.move();


    }

}