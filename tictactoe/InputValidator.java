package tictactoe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidator {
    private static final HashSet<String> VALID_PLAYERS = new HashSet<>(List.of("user", "easy", "medium", "hard"));
    public static boolean areValidCoordinates(String coordinatesStr, Character[][] fields) {
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

    public static boolean areValidCommands(String commands) {
        if (commands == null || commands.isBlank()) {
            System.out.println("Bad parameters!");
            return false;
        }
        String[] commandsArray = commands.split(" ");
        if (commandsArray.length == 1 && "exit".equals(commandsArray[0])) {
            return true;
        }
        if (commandsArray.length != 3) {
            System.out.println("Bad parameters!");
            return false;
        }
        String param1 = commandsArray[0];
        String param2 = commandsArray[1];
        String param3 = commandsArray[2];
        if (!"start".equals(param1)) {
            System.out.println("Bad parameters!");
            return false;
        }
        if (!VALID_PLAYERS.containsAll(List.of(param2, param3))) {
            System.out.println("Bad parameters!");
            return false;
        }
        return true;
    }
}
