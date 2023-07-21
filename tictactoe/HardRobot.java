package tictactoe;

import java.util.Random;

public class HardRobot extends Robot {
    public HardRobot(GameBoard gameBoard) {
        super(gameBoard);
    }

    @Override
    public char move(char player) {
        System.out.println("Making move level \"hard\"");

        Character[][] fields = gameBoard.getFields();

        // coordinates of the best move
        int x = 0;
        int y = 0;
        int bestScore = Integer.MIN_VALUE;
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                if (GameBoard.isEmpty(fields[i][j])) {
                    fields[i][j] = player;
                    int score = minimax(gameBoard, false, switchPlayer(player));
                    fields[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        x = i;
                        y = j;
                    }
                }
            }
        }

        // TODO: implement on the latest version to avoid delay when running tests
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return gameBoard.playAndEvaluate(x, y, player);
    }

    private int getResultScore(String result, char currentPlayer) {
        if ("Draw".equals(result)) {
            return 0;
        }
        if (String.valueOf(currentPlayer).equals(result)) {
            return 1;
        }
        return -1;
    }

    private int minimax(GameBoard gameBoard, boolean isMaximizing, char currentPlayer) {
        String result = gameBoard.evaluate(currentPlayer);
        if (result != null) {
            return getResultScore(result, currentPlayer);
        }
        Character[][] fields = gameBoard.getFields();

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < fields.length; i++) {
                for (int j = 0; j < fields.length; j++) {
                    if (GameBoard.isEmpty(fields[i][j])) {
                        fields[i][j] = currentPlayer;
                        int score = minimax(gameBoard, false, switchPlayer(currentPlayer));
                        fields[i][j] = ' ';
                        bestScore = Integer.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < fields.length; i++) {
                for (int j = 0; j < fields.length; j++) {
                    if (GameBoard.isEmpty(fields[i][j])) {
                        fields[i][j] = currentPlayer;
                        int score = minimax(gameBoard, true, currentPlayer);
                        fields[i][j] = ' ';
                        bestScore = Integer.min(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
    }

    private char switchPlayer(char currentPlayer) {
        return currentPlayer == 'X' ? 'O' : 'X';
    }
}
