import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetMazePathsWithJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        for (String path : solve(1, 1, n, m)) {
            System.out.print(path + " ");
        }
    }

    private static List<String> solve(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        List<String> paths = new ArrayList<>();

        for (int ms = 1; ms <= dc - sc; ms++) {
            List<String> hpaths = solve(sr, sc + ms, dr, dc);
            for (String path : hpaths) {
                paths.add("h" + ms + path);
            }
        }

        for (int ms = 1; ms <= dr - sr; ms++) {
            List<String> vpaths = solve(sr + ms, sc, dr, dc);
            for (String path : vpaths) {
                paths.add("v" + ms + path);
            }

        }

        for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            List<String> dpaths = solve(sr + ms, sc + ms, dr, dc);
            for (String path : dpaths) {
                paths.add("d" + ms + path);
            }
        }
        return paths;
    }
}
