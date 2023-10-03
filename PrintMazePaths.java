import java.util.Scanner;

public class PrintMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        solve(new int[n][m], 0, 0, "");
    }

    private static void solve(int[][] maze, int row, int col, String op) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.print(op + " ");
            return;
        }

        if (row == maze.length || col == maze[0].length) {
            return;
        }

        String op1 = op + "h";
        String op2 = op + "v";
        solve(maze, row, col + 1, op1);
        solve(maze, row + 1, col, op2);
    }
}
