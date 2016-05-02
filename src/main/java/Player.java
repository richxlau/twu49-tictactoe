import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class Player {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Board board;
    private final String playerNumber;
    private final String symbol;

    public Player(PrintStream printStream, BufferedReader bufferedReader, Board board, String playerNumber, String symbol) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
        this.playerNumber = playerNumber;
        this.symbol = symbol;
    }

    public void move() {
        int location = getValidPlayerLocation();
        board.mark(location, symbol);
    }

    private int getValidPlayerLocation() {
        int location;
        boolean locationIsNotEmpty;
        do {
            printStream.println("Player " + playerNumber + ", enter move by choosing a number between 1 and 9");
            location = parseInt(readLine());
            locationIsNotEmpty = !board.isLocationEmpty(location);
            if (locationIsNotEmpty) {
                printStream.println("Location already taken");
            }
        } while (locationIsNotEmpty);
        return location;
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
