import java.util.Scanner;

public class MaxNumberAfterKSwaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        sc.close();
        int ans = solve(str, k, Integer.MIN_VALUE);
        System.out.println(ans);
    }

    private static int solve(String str, int k, int max) {

        if (Integer.parseInt(str) > max) {
            max = Integer.parseInt(str);
        }
        if (k == 0) {
            return max;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    String swappedStr = str.substring(0, i) + ch2 + str.substring(i + 1, j) + ch1
                            + str.substring(j + 1);
                    max = solve(swappedStr, k - 1, max);
                }
            }
        }
        return max;
    }
}
