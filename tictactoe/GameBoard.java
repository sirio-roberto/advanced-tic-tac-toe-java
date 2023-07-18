package tictactoe;

import java.util.Arrays;

public class GameBoard {
    private final int SIZE = 3;
    private Character[][] fields;

    public GameBoard() {
        startEmptyBoard();
    }

    public GameBoard(String initialState) {
        this();
        startFromInitialState(initialState);
    }

    public Character[][] getFields() {
        return fields;
    }

    private void startFromInitialState(String initialState) {
        int k = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char currentChar = initialState.charAt(k);
                if (!isEmpty(currentChar)) {
                    fields[i][j] = currentChar;
                }
                k++;
            }
        }
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

    private char playAndEvaluate(int i, int j, char currentPlayer) {
        play(i, j, currentPlayer);
        evaluate(currentPlayer);
        return switchPlayer(currentPlayer);
    }

    private void evaluate(char currentPlayer) {
        System.out.println(this);

        // check horizontals
        if (!isEmpty(fields[0][0]) && fields[0][0] == fields[0][1] && fields[0][0] == fields[0][2]) {
            System.out.println(currentPlayer + " wins");
        } else if (!isEmpty(fields[1][0]) && fields[1][0] == fields[1][1] && fields[1][0] == fields[1][2]) {
            System.out.println(currentPlayer + " wins");
        } else if (!isEmpty(fields[2][0]) && fields[2][0] == fields[2][1] && fields[2][0] == fields[2][2]) {
            System.out.println(currentPlayer + " wins");
        }
        // check horizontals
        else if (!isEmpty(fields[0][0]) && fields[0][0] == fields[1][0] && fields[0][0] == fields[2][0]) {
            System.out.println(currentPlayer + " wins");
        } else if (!isEmpty(fields[0][1]) && fields[0][1] == fields[1][1] && fields[0][1] == fields[2][1]) {
            System.out.println(currentPlayer + " wins");
        } else if (!isEmpty(fields[0][2]) && fields[0][2] == fields[1][2] && fields[0][2] == fields[2][2]) {
            System.out.println(currentPlayer + " wins");
        }
        // check diagonals
        else if (!isEmpty(fields[0][0]) && fields[0][0] == fields[1][1] && fields[0][0] == fields[2][2]) {
            System.out.println(currentPlayer + " wins");
        } else if (!isEmpty(fields[0][2]) && fields[0][2] == fields[1][1] && fields[0][2] == fields[2][0]) {
            System.out.println(currentPlayer + " wins");
        }
        // check draw
        else if (Arrays.stream(fields)
                .flatMap(Arrays::stream)
                .noneMatch(GameBoard::isEmpty)) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
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
