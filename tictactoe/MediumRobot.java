package tictactoe;

import java.util.Random;

public class MediumRobot extends Robot {
    public MediumRobot(GameBoard gameBoard) {
        super(gameBoard);
    }

    @Override
    public char move(char player) {
        System.out.println("Making move level \"medium\"");

        // check horizontals
        Character[][] fields = gameBoard.getFields();
        if (!GameBoard.isEmpty(fields[0][0]) && GameBoard.isEmpty(fields[0][2]) && fields[0][0] == fields[0][1]) {
            return gameBoard.playAndEvaluate(0, 2, player);
        }
        if (!GameBoard.isEmpty(fields[0][0]) && GameBoard.isEmpty(fields[0][1]) && fields[0][0] == fields[0][2]) {
            return gameBoard.playAndEvaluate(0, 1, player);
        }
        if (!GameBoard.isEmpty(fields[1][0]) && GameBoard.isEmpty(fields[1][2]) && fields[1][0] == fields[1][1]) {
            return gameBoard.playAndEvaluate(1, 2, player);
        }
        if (!GameBoard.isEmpty(fields[1][0]) && GameBoard.isEmpty(fields[1][1]) && fields[1][0] == fields[1][2]) {
            return gameBoard.playAndEvaluate(1, 1, player);
        }
        if (!GameBoard.isEmpty(fields[2][0]) && GameBoard.isEmpty(fields[2][2]) && fields[2][0] == fields[2][1]) {
            return gameBoard.playAndEvaluate(2, 2, player);
        }
        if (!GameBoard.isEmpty(fields[2][0]) && GameBoard.isEmpty(fields[2][1]) && fields[2][0] == fields[2][2]) {
            return gameBoard.playAndEvaluate(2, 1, player);
        }

        // check verticals
        if (!GameBoard.isEmpty(fields[0][0]) && GameBoard.isEmpty(fields[2][0]) && fields[0][0] == fields[1][0]) {
            return gameBoard.playAndEvaluate(2, 0, player);
        }
        if (!GameBoard.isEmpty(fields[0][0]) && GameBoard.isEmpty(fields[1][0]) && fields[0][0] == fields[2][0]) {
            return gameBoard.playAndEvaluate(1, 0, player);
        }
        if (!GameBoard.isEmpty(fields[0][1]) && GameBoard.isEmpty(fields[2][1]) && fields[0][1] == fields[1][1]) {
            return gameBoard.playAndEvaluate(2, 1, player);
        }
        if (!GameBoard.isEmpty(fields[0][1]) && GameBoard.isEmpty(fields[1][1]) && fields[0][1] == fields[2][1]) {
            return gameBoard.playAndEvaluate(1, 1, player);
        }
        if (!GameBoard.isEmpty(fields[0][2]) && GameBoard.isEmpty(fields[2][2]) && fields[0][2] == fields[1][2]) {
            return gameBoard.playAndEvaluate(2, 2, player);
        }
        if (!GameBoard.isEmpty(fields[0][2]) && GameBoard.isEmpty(fields[1][2]) && fields[0][2] == fields[2][2]) {
            return gameBoard.playAndEvaluate(1, 2, player);
        }

        //check diagonals
        if (!GameBoard.isEmpty(fields[0][0]) && GameBoard.isEmpty(fields[2][2]) && fields[0][0] == fields[1][1]) {
            return gameBoard.playAndEvaluate(2, 2, player);
        }
        if (!GameBoard.isEmpty(fields[0][0]) && GameBoard.isEmpty(fields[1][1]) && fields[0][0] == fields[2][2]) {
            return gameBoard.playAndEvaluate(1, 1, player);
        }
        if (!GameBoard.isEmpty(fields[0][2]) && GameBoard.isEmpty(fields[2][0]) && fields[0][2] == fields[1][1]) {
            return gameBoard.playAndEvaluate(2, 0, player);
        }
        if (!GameBoard.isEmpty(fields[0][2]) && GameBoard.isEmpty(fields[1][1]) && fields[0][2] == fields[2][0]) {
            return gameBoard.playAndEvaluate(1, 1, player);
        }

        // if the move cannot win or prevent the opponent victory, play a random move
        Random random = new Random();
        int i;
        int j;

        do {
            i = random.nextInt(3);
            j = random.nextInt(3);
        } while (!GameBoard.isEmpty(gameBoard.getFields()[i][j]));

        // TODO: implement on the latest version to avoid delay when running tests
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return gameBoard.playAndEvaluate(i, j, player);
    }
}
