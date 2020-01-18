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
 *                               CONTROLLER CLASS
 */

public class PennyPitch {

    private ics4m.PennyPitch.Board board = new ics4m.PennyPitch.Board();                      // Create new model object
    private ics4m.PennyPitch.Penny penny = new ics4m.PennyPitch.Penny();                      // Create new model object
    private PennyPitchView View = new PennyPitchView();     // Create new view object

    public static void main(String[] args) {
        new PennyPitch();                                               // New controller object
    }

    private PennyPitch() {                                              // The constructor for the controller
        board.prizeSetup();                                             // Set up the board
        penny.pennyToss(board.Left, board.Right, board.PennyHit);       // Simulate tossing the pennies
        View.display(board.board, board.Left, board.Right);             // Print the board to console
        String result = board.checkPrizes();                            // Check the board for the result
        View.endResult(result);                                         // Prints the results to console
    }
}