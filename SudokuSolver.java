import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        sc.close();
        sudokuSolver(board, 0, 0);
    }

    private static void sudokuSolver(int[][] board, int i, int j) {
        if (i == board.length) {
            System.out.println("The Solution is following::");
            display(board);
            return;
        }
        int ni = 0;
        int nj = 0;

        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != 0) {
            sudokuSolver(board, ni, nj);
        } else {
            for (int po = 1; po <= 9; po++) {
                if (isValid(board, i, j, po) == true) {
                    board[i][j] = po;
                    sudokuSolver(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static void display(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int[][] board, int x, int y, int val) {

        for (int j = 0; j < board[0].length; j++) {
            if (board[x][j] == val)
                return false;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[i][y] == val)
                return false;
        }

        int sRow = 3 * (x / 3);
        int sCol = 3 * (y / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + sRow][j + sCol] == val)
                    return false;
            }
        }
        return true;
    }
}
