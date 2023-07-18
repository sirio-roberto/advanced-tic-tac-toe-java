package tictactoe;

public class RobotFactory {
    private GameBoard gameBoard;

    public RobotFactory(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Robot generateRobot(String difficulty) {
        return switch (difficulty) {
            case "easy" -> new EasyRobot(gameBoard);
            default -> null;
        };
    }
}
