package tictactoe;

import java.util.Arrays;

public class GameBoard {

    private boolean over = false;
    private final int SIZE = 3;
    private Character[][] fields;

    public GameBoard() {
        startEmptyBoard();
    }

    public Character[][] getFields() {
        return fields;
    }

    public boolean isOver() {
        return over;
    }

    public static boolean isEmpty(char c) {
        return c == ' ' || c == '_';
    }

    private void startEmptyBoard() {
        fields = new Character[SIZE][SIZE];
        for (Character[] row: fields) {
            Arrays.fill(row, ' ');
        }
    }

    public char playAndEvaluate(String coordinatesStr, char currentPlayer) {
        String[] coordinatesStrArray = coordinatesStr.split(" ");
        int i = Integer.parseInt(coordinatesStrArray[0]);
        int j = Integer.parseInt(coordinatesStrArray[1]);
        return playAndEvaluate(i - 1, j - 1, currentPlayer);
    }

    public char playAndEvaluate(int i, int j, char currentPlayer) {
        play(i, j, currentPlayer);
        String result = evaluate(currentPlayer);
        System.out.println(this);
        printResult(result);
        return switchPlayer(currentPlayer);
    }

    private void printResult(String result) {
        if (result != null) {
            if ("Draw".equals(result)) {
                System.out.println(result);
            } else {
                System.out.println(result + " wins");
            }
        }
    }

    public String evaluate(char currentPlayer) {
        over = true;

        // check horizontals
        if (!isEmpty(fields[0][0]) && fields[0][0] == fields[0][1] && fields[0][0] == fields[0][2]) {
            return String.valueOf(currentPlayer);
        } else if (!isEmpty(fields[1][0]) && fields[1][0] == fields[1][1] && fields[1][0] == fields[1][2]) {
            return String.valueOf(currentPlayer);
        } else if (!isEmpty(fields[2][0]) && fields[2][0] == fields[2][1] && fields[2][0] == fields[2][2]) {
            return String.valueOf(currentPlayer);
        }
        // check horizontals
        else if (!isEmpty(fields[0][0]) && fields[0][0] == fields[1][0] && fields[0][0] == fields[2][0]) {
            return String.valueOf(currentPlayer);
        } else if (!isEmpty(fields[0][1]) && fields[0][1] == fields[1][1] && fields[0][1] == fields[2][1]) {
            return String.valueOf(currentPlayer);
        } else if (!isEmpty(fields[0][2]) && fields[0][2] == fields[1][2] && fields[0][2] == fields[2][2]) {
            return String.valueOf(currentPlayer);
        }
        // check diagonals
        else if (!isEmpty(fields[0][0]) && fields[0][0] == fields[1][1] && fields[0][0] == fields[2][2]) {
            return String.valueOf(currentPlayer);
        } else if (!isEmpty(fields[0][2]) && fields[0][2] == fields[1][1] && fields[0][2] == fields[2][0]) {
            return String.valueOf(currentPlayer);
        }
        // check draw
        else if (Arrays.stream(fields)
                .flatMap(Arrays::stream)
                .noneMatch(GameBoard::isEmpty)) {
            return "Draw";
        }
        over = false;
        return null;
    }

    private void play(int i, int j, char player) {
        fields[i][j] = player;
    }

    private char switchPlayer(char currentPlayer) {
        return currentPlayer == 'X' ? 'O' : 'X';
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("---------");
        result.append("\n");

        for (Character[] row: fields) {
            result.append("| ");
            for (char c: row) {
                result.append(c).append(" ");
            }
            result.append("|").append("\n");
        }
        result.append("---------");

        return result.toString();
    }
}
