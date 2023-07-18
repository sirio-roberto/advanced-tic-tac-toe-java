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
            do {
                System.out.print("Input command: ");
                commands = scanner.nextLine();
            } while (!InputValidator.areValidCommands(commands));

            if (!"exit".equals(commands)) {
                String[] commandsArray = commands.split(" ");
                 firstPlayer = commandsArray[1];
                 secondPlayer = commandsArray[2];

                GameBoard board = new GameBoard();
                System.out.println(board);

                RobotFactory factory = new RobotFactory(board);

                while (!board.isOver()) {
                    if (currentPlayer == 'X') {
                        if ("user".equals(firstPlayer)) {
                            handleUserMove(board);
                        } else {
                            handleRobotMove(factory);
                        }
                    } else {
                        if ("user".equals(secondPlayer)) {
                            handleUserMove(board);
                        } else {
                            handleRobotMove(factory);
                        }
                    }
                }
                System.out.println();
            }
        } while (!"exit".equals(commands));

    }

    private static void handleRobotMove(RobotFactory factory) {
        Robot robot = factory.generateRobot("easy");
        currentPlayer = robot.move(currentPlayer);
    }

    private static void handleUserMove(GameBoard board) {
        String coordinatesStr;
        do {
            System.out.print("Enter the coordinates: ");
            coordinatesStr = scanner.nextLine();
        } while (!InputValidator.areValidCoordinates(coordinatesStr, board.getFields()));

        currentPlayer = board.playAndEvaluate(coordinatesStr, currentPlayer);
    }
}
