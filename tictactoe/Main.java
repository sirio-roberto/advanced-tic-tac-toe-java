package tictactoe;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static char currentPlayer = 'X';

    private static String firstPlayer;
    private static String secondPlayer;

    public static void main(String[] args) {
        String commands;
        do {
            System.out.print("Input command: ");
            commands = scanner.nextLine();
        } while (!InputValidator.areValidCommands(commands));

        GameBoard board = new GameBoard();
        System.out.println(board);

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
}
