import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        int[][] maze = new int[n][m];
        for (String ans : solve(maze, 0, 0)) {
            System.out.print(ans + " ");
        }
    }

    private static List<String> solve(int[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        if (row == maze.length || col == maze[0].length) {
            List<String> bres = new ArrayList<>();
            return bres;
        }

        List<String> hpaths = solve(maze, row, col + 1);
        List<String> vpaths = solve(maze, row + 1, col);
        List<String> paths = new ArrayList<>();

        for (String path : hpaths) {
            paths.add("h" + path);
        }

        for (String path : vpaths) {
            paths.add("v" + path);
        }

        return paths;
    }
}
