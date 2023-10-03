import java.util.Scanner;

public class PrintStairPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        solve(n, "");
    }

    private static void solve(int n, String op) {
        if (n == 0) {
            System.out.print(op + " ");
            return;
        }
        if (n < 0) {
            return;
        }

        for (int js = 1; js <= 3; js++) {
            String op1 = op + js;
            solve(n - js, op1);
        }
    }
}
