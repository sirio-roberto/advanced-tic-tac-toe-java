package tictactoe;

abstract class Robot {

    protected GameBoard gameBoard;

    public Robot(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
    abstract char move(char player);
}
