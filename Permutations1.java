import java.util.Scanner;

public class Permutations1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        sc.close();
        int[] ans = new int[n];
        solve(1, n, r, ans);
    }

    private static void solve(int k, int n, int r, int[] ans) {

        if (k > r) {
            String op = "";
            for (int ele : ans)
                op += ele;
            System.out.println(op);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                ans[i] = k;
                solve(k + 1, n, r, ans);
                ans[i] = 0;
            }
        }
    }
}
