package tictactoe;

import java.util.Random;

public class EasyRobot extends Robot {
    public EasyRobot(GameBoard gameBoard) {
        super(gameBoard);
    }

    @Override
    public char move(char player) {
        System.out.println("Making move level \"easy\"");

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
