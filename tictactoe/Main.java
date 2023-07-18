package tictactoe;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
//        System.out.print("Enter the cells: ");
//        String initialState = scanner.nextLine();

        GameBoard board = new GameBoard();
        System.out.println(board);

//        setCurrentPlayer(initialState);
        RobotFactory factory = new RobotFactory(board);
        Robot robot = factory.generateRobot("easy");

        while (!board.isOver()) {
            if (currentPlayer == 'X') {
                String coordinatesStr;
                do {
                    System.out.print("Enter the coordinates: ");
                    coordinatesStr = scanner.nextLine();
                } while (!InputValidator.areValidCoordinates(coordinatesStr, board.getFields()));

                currentPlayer = board.playAndEvaluate(coordinatesStr, currentPlayer);
            } else {
                currentPlayer = robot.move(currentPlayer);
            }
        }

    }

    private static void setCurrentPlayer(String initialState) {
        int playerCount = 0;
        for (char c: initialState.toCharArray()) {
            if (c == 'X') {
                playerCount++;
            } else if (c == 'O') {
                playerCount--;
            }
        }
        if (playerCount > 0) {
            currentPlayer = 'O';
        }
    }
}
