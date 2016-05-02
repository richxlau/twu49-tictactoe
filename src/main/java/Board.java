import java.io.PrintStream;
import java.util.List;

public class Board {
    private final PrintStream printStream;
    private List<String> locations;

    public Board(PrintStream printStream, List<String> locations) {
        this.printStream = printStream;
        this.locations = locations;
    }

    public void draw() {
        printStream.println(
                locations.get(0) +"|" + locations.get(1) + "|" + locations.get(2) + "\n" +
                "-----\n" +
                locations.get(3) +"|" + locations.get(4) + "|" + locations.get(5) + "\n" +
                "-----\n" +
                locations.get(6) +"|" + locations.get(7) + "|" + locations.get(8)
        );
    }

    public void mark(int position, String symbol) {
        locations.set(position - 1, symbol);
    }

    public boolean isLocationEmpty(int location) {
        boolean locationIsEmpty = false;
        int boardIndex = location - 1;
        String markAtLocation = locations.get(boardIndex);
        locationIsEmpty |= markAtLocation.equals("X");
        locationIsEmpty |= markAtLocation.equals("O");
        return locationIsEmpty;
    }
}
