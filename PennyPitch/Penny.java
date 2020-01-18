package ics4m.PennyPitch;

/**
 * Assignment Name: Penny Pitch
 * Author: Ernst Mach and Peter Ke
 * Date: September 19, 2018
 * Description: This application randomly generates a 5 by 5 board
 * with certain areas being marked with different prizes. The application then
 * simulates 10 pennies being tossed onto the board. A starting board will be
 * created first with the items placed randomly. Afterwards the application will
 * simulate tossing the pennies and display the results. When a penny has
 * landed on a space it will be indicated by a set of square brackets.
 * If the pennies manages to land on 3 of the same prizes, the user wins that prize.
 *                               MODEL CLASS
 */

public class Penny {

    int coinToss = 0;                                   // Sets the amount of times the penny has been tossed to 0
    String LeftHit = "[";                               // String used as hit marker indication for when a penny has landed on a spot
    String RightHit = "]";
    String Empty = "";                                  // String used to change the array from null to a blank
    int randomRow;                                      // Value used to hold randomly generated row
    int randomColumn;                                   // Value used to hold randomly generated column

    void pennyToss(String[][] left, String[][] right, boolean[][] pennyHit) {                       // Function for tossing the penny

        // Goes through each column and row of the board and sets everything to empty
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                right[row][column] = Empty;
                left[row][column] = Empty;
            }
        }

        while (coinToss < 10) {                                         // Tosses only 10 coins
            randomRow = (int) (Math.random() * 5);                      // Randomly chooses a number between 0-5 for the row
            randomColumn = (int) (Math.random() * 5);                   // Randomly chooses a number between 0-5 for the column
            if (!pennyHit[randomRow][randomColumn]) {                   // Checks if the penny has already hit that square
                right[randomRow][randomColumn] = RightHit;              // Hit markers to show that the penny has it the square visually
                left[randomRow][randomColumn] = LeftHit;
                pennyHit[randomRow][randomColumn] = true;               // Indicates that the penny has hit that square

                // Checks if the square the penny landed on had a prize on it, if it does the counter for that prize increases by 1
                if (ics4m.PennyPitch.Board.Puzzle.board(randomRow, randomColumn)) {
                    ics4m.PennyPitch.Board.Puzzle.increasePoint();
                }
                if (ics4m.PennyPitch.Board.Poster.board(randomRow, randomColumn)) {
                    ics4m.PennyPitch.Board.Poster.increasePoint();
                }
                if (ics4m.PennyPitch.Board.Ball.board(randomRow, randomColumn)) {
                    ics4m.PennyPitch.Board.Ball.increasePoint();
                }
                if (ics4m.PennyPitch.Board.Game.board(randomRow, randomColumn)) {
                    ics4m.PennyPitch.Board.Game.increasePoint();
                }
                if (ics4m.PennyPitch.Board.Doll.board(randomRow, randomColumn)) {
                    ics4m.PennyPitch.Board.Doll.increasePoint();
                }
                coinToss++;                                             // Increases the coin tossed counter by 1
            }
        }
    }
}
