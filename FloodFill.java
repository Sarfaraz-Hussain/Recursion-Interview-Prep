import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        sc.close();
        boolean[][] visited = new boolean[n][m];
        solve(maze, 0, 0, "", visited);
    }

    private static void solve(int[][] maze, int row, int col, String op, boolean[][] visited) {
        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1
                || visited[row][col] == true) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.print(op + " ");
            return;
        }

        visited[row][col] = true;
        solve(maze, row - 1, col, op + "t", visited);
        solve(maze, row, col - 1, op + "l", visited);
        solve(maze, row + 1, col, op + "d", visited);
        solve(maze, row, col + 1, op + "r", visited);
        visited[row][col] = false;
    }
}
