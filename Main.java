import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }

        for (int i = 0; i < 9; i++) {
            System.out.println(printBoard(board));
            if (i % 2 == 0) {
                playerMove(board, 'X');
                if (checkWins(board, 'X')) {
                    System.out.println(printBoard(board));
                    System.out.println("X wins");
                    break;
                }
            } else {
                playerMove(board, 'O');
                if (checkWins(board, 'O')) {
                    System.out.println(printBoard(board));
                    System.out.println("O wins");
                    break;
                }
            }
            if (i == 8) {
                System.out.println(printBoard(board));
                System.out.println("Draw");
            }
        }

    }

    public static String printBoard(char[][] board) {
        String line1And5 = "---------\n";
        String line2 = "| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |\n";
        String line3 = "| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |\n";
        String line4 = "| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |\n";
        return line1And5 + line2 + line3 + line4 + line1And5;
    }


    public static void playerMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        boolean validMove = true;
        while (validMove) {
            System.out.println("Enter the coordinates:");
            try {
                byte firstCoordinate = (byte) (scanner.nextByte() - 1);
                byte secondCoordinate = (byte) (scanner.nextByte() - 1);
                if (firstCoordinate > 2 || secondCoordinate > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[firstCoordinate][secondCoordinate] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[firstCoordinate][secondCoordinate] = player;
                    validMove = false;
                }
            } catch (Exception NumFormatException) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }

        }
    }

    public static boolean checkWins(char[][] board, char symbol) {
        boolean horizontalWin1 = board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] == symbol;
        boolean horizontalWin2 = board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] == symbol;
        boolean horizontalWin3 = board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] == symbol;

        boolean verticalWin1 = board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] == symbol;
        boolean verticalWin2 = board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] == symbol;
        boolean verticalWin3 = board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] == symbol;

        boolean diagonalWin1 = board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == symbol;
        boolean diagonalWin2 = board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == symbol;
        if (horizontalWin1 || horizontalWin2 || horizontalWin3 || verticalWin1 || verticalWin2 || verticalWin3 ||
                diagonalWin1 || diagonalWin2) return true;
        else return false;
    }
}