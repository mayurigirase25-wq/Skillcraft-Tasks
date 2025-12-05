import java.util.Scanner;

public class SudokuSolver {

    // Print Sudoku board
    static void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    // Check if placing num is safe
    static boolean isSafe(int[][] board, int row, int col, int num) {

        // Row check
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == num) return false;
        }

        // Column check
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == num) return false;
        }

        // 3x3 box check
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == num) return false;
            }
        }

        return true;
    }

    // Backtracking solver
    static boolean solveSudoku(int[][] board) {

        int row = -1, col = -1;
        boolean emptyFound = false;

        // Find empty cell
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == 0) {
                    row = r;
                    col = c;
                    emptyFound = true;
                    break;
                }
            }
            if (emptyFound) break;
        }

        // No empty cell → solved
        if (!emptyFound) return true;

        // Try 1 to 9
        for (int num = 1; num <= 9; num++) {

            if (isSafe(board, row, col, num)) {
                board[row][col] = num; // place number

                if (solveSudoku(board)) return true;

                board[row][col] = 0; // backtrack
            }
        }

        return false; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];

        System.out.println("Enter the Sudoku puzzle (use 0 for empty cells):");

        // Take input
        for (int i = 0; i < 9; i++) {
            System.out.println("Enter row " + (i + 1) + " (9 numbers):");
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // Solve
        if (solveSudoku(board)) {
            System.out.println("\nSolved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }

        sc.close();
    }
}
