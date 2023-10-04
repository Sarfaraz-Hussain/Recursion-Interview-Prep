import java.util.Scanner;

public class NQueenUsingBranchAndBound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[][] chess = new int[N][N];
        boolean[] cols = new boolean[N];
        boolean[] md = new boolean[2 * N - 1];
        boolean[] ad = new boolean[2 * N - 1];
        solve(chess, cols, md, ad, N, 0, "");
    }

    private static void solve(int[][] chess, boolean[] cols, boolean[] md, boolean[] ad, int N, int row, String op) {
        if (row == chess.length) {
            System.out.println(op);
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (cols[col] == false && md[row + col] == false && ad[row - col + N - 1] == false) {
                chess[row][col] = 1;
                cols[col] = md[row + col] = ad[row - col + N - 1] = true;
                solve(chess, cols, md, ad, N, row + 1, op + row + "-" + col + " ");
                chess[row][col] = 0;
                cols[col] = md[row + col] = ad[row - col + N - 1] = false;
            }
        }
    }
}
