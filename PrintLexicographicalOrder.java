import java.util.Scanner;

public class PrintLexicographicalOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
    }

    private static void dfs(int i, int n) {
        if (i > n)
            return;

        System.out.print(i + " ");
        for (int j = 0; j <= 9; j++) {
            dfs(10 * i + j, n);
        }
    }
}