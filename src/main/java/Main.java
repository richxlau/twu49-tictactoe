import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        List<String> locations = new ArrayList<>();
        for (int locationIndex = 0; locationIndex < 9; locationIndex++) {
            locations.add(Integer.toString(locationIndex + 1));
        }

        Board board = new Board(printStream, locations);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player playerOne = new Player(printStream, bufferedReader, board, "1", "X");
        Player playerTwo = new Player(printStream, bufferedReader, board, "2", "O");
        Game game = new Game(board, playerOne, playerTwo);
        game.start();
    }
}
