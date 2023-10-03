import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetStairPaths {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for (String ans : solve(n)) {
            System.out.print(ans + " ");
        }
    }

    private static List<String> solve(int n) {
        if (n == 0) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        if (n < 0) {
            List<String> bres = new ArrayList<>();
            return bres;
        }

        List<String> one = solve(n - 1);
        List<String> two = solve(n - 2);
        List<String> three = solve(n - 3);

        List<String> ans = new ArrayList<>();

        for (String ele : one) {
            ans.add("1" + ele);
        }

        for (String ele : two) {
            ans.add("2" + ele);
        }

        for (String ele : three) {
            ans.add("3" + ele);
        }

        return ans;
    }
}
