package tictactoe;

import java.util.Arrays;

public class GameBoard {
    private final int SIZE = 3;
    private char[][] fields;

    public GameBoard() {
        startEmptyBoard();
    }

    public GameBoard(String initialState) {
        this();
        startFromInitialState(initialState);
    }

    public char[][] getFields() {
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
        fields = new char[SIZE][SIZE];
        for (char[] row: fields) {
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
        evaluate();
        return switchPlayer(currentPlayer);
    }

    private void evaluate() {
        System.out.println(this);
        System.out.println("check game status");
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

        for (char[] row: fields) {
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
