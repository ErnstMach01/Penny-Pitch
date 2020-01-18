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

public class Board {

    static int row = 5;                                        // Sets the row size of the board
    static int column = 5;                                     // Sets the column size of the board
    String[][] board = new String[row][column];                // String being used as the 2D board

    static String[][] Left = new String[row][column];          // Creates a 2D array for the hit marker used to indicate which squares the penny landed on
    static String[][] Right = new String[row][column];
    static boolean[][] PennyHit = new boolean[row][column];    // Creates a 2D array to store which squares the penny hits during the toss

    //Creates all the different prizes
    static ics4m.PennyPitch.Prize Puzzle = new ics4m.PennyPitch.Prize();
    static ics4m.PennyPitch.Prize Poster = new ics4m.PennyPitch.Prize();
    static ics4m.PennyPitch.Prize Ball = new ics4m.PennyPitch.Prize();
    static ics4m.PennyPitch.Prize Game = new ics4m.PennyPitch.Prize();
    static ics4m.PennyPitch.Prize Doll = new ics4m.PennyPitch.Prize();

    void prizeSetup() {                                         // Sets up the board and the prizes
        int prizesPlaced = 0;                                   // The amount of prizes placed on the board
        String Award = "Empty";                                 // Used to indicate that all the spots are empty
        int randomRow;                                          // Value used to hold the randomly generated row
        int randomColumn;                                       // Value used to hold the randomly generated column

        // Goes through each column and row of the board and sets everything to false indicating noting has been placed yet
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                board[row][column] = Award;
                PennyHit[row][column] = false;
            }
        }

        // Clears all of the prizes so that no prizes have been placed on the board
        Puzzle.clear();
        Poster.clear();
        Ball.clear();
        Game.clear();
        Doll.clear();

        while (prizesPlaced < 15) {                                             // Only places 15 prizes
            if (Puzzle.getPrizesPlaced() < 3) {                                    // Only places 3 puzzles
                Award = "Puzzle";                                               // Sets the award string to puzzle
                randomRow = (int) (Math.random() * 5);                          // Randomly chooses a number between 0-5 for the row
                randomColumn = (int) (Math.random() * 5);                       // Randomly chooses a number between 0-5 for the column
                if (board[randomRow][randomColumn].equals("Empty")) {           // Checks if the random spot is occupied or not
                    board[randomRow][randomColumn] = Award;                     // and then places an award at that location
                    Puzzle.setBoard(randomRow, randomColumn, true);             // Indicates that the square is now occupied
                    prizesPlaced++;                                             // Increases the amount of prizes that have been placed by 1
                    Puzzle.getPrizePlaced();                                       // Increases the amount of puzzles that have been placed by 1
                }
            }

            if (Poster.getPrizesPlaced() < 3) {                                    // Only places 3 posters
                Award = "Poster";                                               // Sets the award string to poster
                randomRow = (int) (Math.random() * 5);                          // Randomly chooses a number between 0-5 for the row
                randomColumn = (int) (Math.random() * 5);                       // Randomly chooses a number between 0-5 for the column
                if (board[randomRow][randomColumn].equals("Empty")) {           // Checks if the random spot is occupied or not
                    board[randomRow][randomColumn] = Award;                     // and then places an award at that location
                    Poster.setBoard(randomRow, randomColumn, true);             // Indicates that the square is now occupied
                    prizesPlaced++;                                             // Increases the amount of prizes that have been placed by 1
                    Poster.getPrizePlaced();                                       // Increases the amount of posters that have been placed by 1
                }
            }

            if (Ball.getPrizesPlaced() < 3) {                                      // Only places 3 balls
                Award = "Ball";                                                 // Sets the award string to ball
                randomRow = (int) (Math.random() * 5);                          // Randomly chooses a number between 0-5 for the row
                randomColumn = (int) (Math.random() * 5);                       // Randomly chooses a number between 0-5 for the column
                if (board[randomRow][randomColumn].equals("Empty")) {           // Checks if the random spot is occupied or not
                    board[randomRow][randomColumn] = Award;                     // and then places an award at that location
                    Ball.setBoard(randomRow, randomColumn, true);               // Indicates that the square is now occupied
                    prizesPlaced++;                                             // Increases the amount of prizes that have been placed by 1
                    Ball.getPrizePlaced();                                         // Increases the amount of balls that have been placed by 1
                }
            }

            if (Game.getPrizesPlaced() < 3) {                                      // Only places 3 games
                Award = "Game";                                                 // Sets the award string to game
                randomRow = (int) (Math.random() * 5);                          // Randomly chooses a number between 0-5 for the row
                randomColumn = (int) (Math.random() * 5);                       // Randomly chooses a number between 0-5 for the column
                if (board[randomRow][randomColumn].equals("Empty")) {           // Checks if the random spot is occupied or not
                    board[randomRow][randomColumn] = Award;                     // and then places an award at that location
                    Game.setBoard(randomRow, randomColumn, true);               // Indicates that the square is now occupied
                    prizesPlaced++;                                             // Increases the amount of prizes that have been placed by 1
                    Game.getPrizePlaced();                                         // Increases the amount of games that have been placed by 1
                }
            }

            if (Doll.getPrizesPlaced() < 3) {                                      // Only places 3 dolls
                Award = "Doll";                                                 // Sets the award string to doll
                randomRow = (int) (Math.random() * 5);                          // Randomly chooses a number between 0-5 for the row
                randomColumn = (int) (Math.random() * 5);                       // Randomly chooses a number between 0-5 for the column
                if (board[randomRow][randomColumn].equals("Empty")) {                // Checks if the random spot is occupied or not
                    board[randomRow][randomColumn] = Award;                     // and then places an award at that location
                    Doll.setBoard(randomRow, randomColumn, true);               // Indicates that the square is now occupied
                    prizesPlaced++;                                             // Increases the amount of prizes that have been placed by 1
                    Doll.getPrizePlaced();                                         // Increases the amount of dolls that have been placed by 1
                }
            }
        }
    }

    String checkPrizes() {                                                      // Checks which prize the user has won if any based on if the penny has landed on three of the same prize
        String puzzle = Puzzle.checkPrize("Puzzle");                            // Checks if the user won a puzzle
        String poster = Poster.checkPrize("Poster");                            // Checks if the user won a poster
        String ball = Ball.checkPrize("Ball");                                  // Checks if the user won a ball
        String game = Game.checkPrize("Game");                                  // Checks if the user won a game
        String doll= Doll.checkPrize("Doll");                                   // Checks if the user won a doll
        String totalPrize = "\n" + puzzle + poster + ball + game + doll;

        if(totalPrize.equals("\n")) {                                           // Checks to see what prizes have been won
            return null;
        } else {
            return totalPrize;
        }
    }
}