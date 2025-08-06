 import java.util.*;
 public class Project2 {
    // TIC TAE TOE GAME
       static char[][] board = new char [3][3];

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    // Wining Condition

    public static boolean checkWin(char player) {
        // Rows and columns
       
        for (int i = 0; i < 3; i++) {
            if (
                (board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)
            ) {
                return true;
            }
        }

        // Diagonals
        if (
            (board[0][0] == player && board[1][1] == player && board[2][2] == player) || 
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)
        ) {
            return true;
        }

        return false;
    }
    // Check if the board is fulled or not

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

     public static void main(String[] args){
          Scanner scanner = new Scanner(System.in);
          char currPlayer = 'X';
          boolean gameContinue = true;
          System.out.println("WELCOME TO TIC TAE TOE GAME ");
          
          for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 board[i][j] = ' ';     
           }
        }

       
        printBoard();
        while (gameContinue) {
            System.out.println("Player " + currPlayer + ", enter your move (row and column: 1-3):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;


            // Invalid Case

             if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid move! Try again.");
                continue;
            }
             if (board[row][col] != ' ') {
                 System.out.println("That Box is already filled! Fill another box.");
                 continue;    
            }
             board[row][col] = currPlayer;
            printBoard();
             // Check for win

            if (checkWin(currPlayer)) {
                System.out.println("Player " + currPlayer + " wins!");
                gameContinue = false;
            } else if (isBoardFull()) {
                System.out.println("The game is a draw!");
                gameContinue = false;
            } else {
                // Switch player
                if (currPlayer == 'X') {
                   currPlayer = 'O';
                } else {
                    currPlayer = 'X';
                }

            }
        }

        scanner.close();
        }
     }




    

