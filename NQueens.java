import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[][] chess = new int[N][N];
        solve(chess, 0, "");
    }

    private static void solve(int[][] chess, int row, String op) {
        if (chess.length == row) {
            System.out.println(op);
            return;
        }

        for (int col = 0; col < chess[0].length; col++) {
            if (isItSafePositionForQueenToBePlace(chess, row, col)) {
                chess[row][col] = 1;
                solve(chess, row + 1, op + row + "-" + col + " ");
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isItSafePositionForQueenToBePlace(int[][] chess, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--)
            if (chess[i][j] == 1)
                return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chess[i][j] == 1)
                return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++)
            if (chess[i][j] == 1)
                return false;
        return true;
    }
}