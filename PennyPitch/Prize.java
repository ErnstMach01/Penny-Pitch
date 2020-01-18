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

public class Prize {
    private Boolean[][] PrizeHit = new Boolean[ics4m.PennyPitch.Board.row][ics4m.PennyPitch.Board.column];                                  // Creates a simulation of the board to check where the prizes have been placed
    private int PrizePlaced = 0;                                                                          // Variable to check the number of prizes that haven been placed
    private int PrizePoint = 0;                                                                           // Variable to check if the penny has landed on a prize space

    // Function that sets the entire board to false indicating that no prizes have been placed
    void clear() {
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                PrizeHit[row][column] = false;
            }
        }
    }

    // Function to check a position on the board
    Boolean board(int row, int column) {
        return PrizeHit[row][column];
    }

    // Function to change a position on the board from false to true, indicating a prize has been placed
    void setBoard (int row, int column, boolean mode) {
        PrizeHit[row][column] = mode;
    }

    // Function used to check how many prizes have been placed
    int getPrizesPlaced() {
        return this.PrizePlaced;
    }

    // Function used to increase the number of prizes that have been placed
    void getPrizePlaced() {
        PrizePlaced++;
    }

    // Function that acts as a counter to how many prizes the pennies have currently landed on
    void increasePoint() {
        PrizePoint++;
    }

    // Function that returns what prizes the user has won
    String checkPrize(String PrizeName){
        if(PrizePoint == 3) {
            return "You have won a " + PrizeName + "\n";
        } else {
            return "";
        }
    }
}
