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
 *                               VIEW CLASS
 */

public class PennyPitchView {

    void display(String[][] board, String[][] left, String[][] right) {                         // Prints the starting board to the console for the user to see and then prints where the pennies have been tossed
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                System.out.format("%-4s %-6s %4s", "[",  board[row][column] , "]");
            }
            System.out.println();
        }
        System.out.println("\n Tossing pennies.... Results being displayed\n");
        // Prints the result to the console for the user to see
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                System.out.format("%-1s %-2s %-6s %2s %1s", "[", left[row][column], board[row][column], right[row][column], "]");
            }
            System.out.println();
        }
    }

    void endResult(String prize) {                                                              // Indicates which prizes the user has won
        if (prize == null) {
            System.out.println("\nYou won no prizes. Try again?");
            return;
        }
        System.out.println(prize);
    }
}

