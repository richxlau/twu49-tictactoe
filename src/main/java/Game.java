
public class Game {
    private final Board board;
    private Player playerOne;
    private final Player playerTwo;

    public Game(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        board.draw();
        playerOne.move();
        board.draw();
        playerTwo.move();
        board.draw();
    }

}
