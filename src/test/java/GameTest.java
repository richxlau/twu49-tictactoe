import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {
    private Board board;
    private Game game;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, playerOne, playerTwo);
    }

    @Test
    public void shouldDrawBoardTwiceWhenStarting() {
        game.start();

        verify(board, times(3)).draw();
    }

    @Test
    public void shouldTellPlayerOneToMoveWhenStarting() {
        game.start();

        verify(playerOne).move();
    }

    @Test
    public void shouldTellPlayerTwoToMoveWhenStarting() {
        game.start();

        verify(playerTwo).move();
    }



}