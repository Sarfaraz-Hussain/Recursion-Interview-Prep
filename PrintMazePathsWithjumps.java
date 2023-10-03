import java.util.Scanner;

public class PrintMazePathsWithjumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        solve(1, 1, n, m, "");
    }

    private static void solve(int sr, int sc, int dr, int dc, String op) {
        if (sr == dr && sc == dc) {
            System.out.print(op + " ");
            return;
        }

        for (int ms = 1; ms <= dc - sc; ms++) {
            String op1 = op + "h" + ms;
            solve(sr, sc + ms, dr, dc, op1);
        }

        for (int ms = 1; ms <= dr - sr; ms++) {
            String op1 = op + "v" + ms;
            solve(sr + ms, sc, dr, dc, op1);
        }

        for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            String op1 = op + "d" + ms;
            solve(sr + ms, sc + ms, dr, dc, op1);
        }
    }
}
