package tictactoe;

public class InputValidator {
    public static boolean areValidCoordinates(String coordinatesStr, char[][] fields) {
        if (coordinatesStr == null || coordinatesStr.isBlank()) {
            System.out.println("Please type the coordinates");
            return false;
        }
        String[] coordinatesStrArray = coordinatesStr.split(" ");
        if (coordinatesStrArray.length != 2) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (!coordinatesStrArray[0].matches("\\d") || !coordinatesStrArray[1].matches("\\d")) {
            System.out.println("You should enter numbers!");
            return false;
        }
        int i = Integer.parseInt(coordinatesStrArray[0]);
        int j = Integer.parseInt(coordinatesStrArray[1]);
        if (i < 1 || j < 1 || i > 3 || j > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (!GameBoard.isEmpty(fields[i - 1][j - 1])) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }
}
