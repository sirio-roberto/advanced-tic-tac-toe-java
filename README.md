# Tic-Tac-Toe Game

Welcome to the Tic-Tac-Toe game! This is a two-player game where you compete against either another player or various levels of AI robots: Easy, Medium, and Hard. The objective of the game is to be the first player to form a line of three consecutive symbols (X or O) either horizontally, vertically, or diagonally on the 3x3 game board.

## How to Play

1. The game board is represented by a 3x3 grid. Each cell can be empty (' ') or filled with either 'X' or 'O' depending on the player's move.

2. Players take turns to make their moves. The game starts with 'X' player.

3. The game prompts the current player to enter the coordinates (row and column) where they want to place their symbol. The coordinates are specified by two space-separated numbers, each ranging from 1 to 3.

4. To make a move, enter the row and column numbers when prompted, e.g., "1 1" to place your symbol in the top-left corner of the board.

5. The game continues until one player wins or the board is fully filled (resulting in a draw).

## Player Types

There are three types of players in the game:

- **User Player**: This player is controlled by a human and makes moves based on user input.

- **Easy Robot**: The Easy Robot makes random moves on the board, making it the easiest opponent to beat.

- **Medium Robot**: The Medium Robot plays at an intermediate level. It tries to win if it has two symbols in a row, column, or diagonal. Otherwise, it blocks its opponent's winning move if possible.

- **Hard Robot**: The Hard Robot is a challenging opponent. It uses the minimax algorithm to search for the best possible move and tries to win the game or force a draw if the user makes a mistake.

## Starting the Game

To start the game, run the `Main` class. You will be prompted to enter commands to set up the game:

- To play against another user: Type `start user user` and press Enter.
- To play against the robots: Type `start user easy`, `start user medium`, or `start user hard` to select the robot difficulty level.

## Example Gameplay

```
Input command: start user hard

---------
|       |
|       |
|       |
---------

Enter the coordinates: 1 1
---------
| X     |
|       |
|       |
---------

Making move level "hard"
---------
| X     |
|   O   |
|       |
---------

Enter the coordinates: 2 2
---------
| X     |
|   O   |
|     X |
---------

Making move level "hard"
---------
| X     |
|   O   |
| O   X |
---------

Enter the coordinates: 3 1
---------
| X     |
|   O   |
| O X X |
---------

X wins
```

Enjoy the game and have fun playing Tic-Tac-Toe!