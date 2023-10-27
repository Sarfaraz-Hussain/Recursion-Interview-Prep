import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TugOfWar {

    static String ans = "-1";
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
        System.out.println(ans);
    }

    private static void solve(int[] arr, int vidx, List<Integer> set1, List<Integer> set2, int soset1, int soset2) {
        if (vidx == arr.length) {
            int currMin = Math.min(minDiff, (int) Math.abs(soset1 - soset2));
            if (currMin < minDiff) {
                minDiff = currMin;
                ans = set1.toString() + " " + set2.toString();
            }
            return;
        }

        int n = arr.length;
        if (set1.size() < (n + 1) / 2) {
            set1.add(arr[vidx]);
            solve(arr, vidx + 1, set1, set2, soset1 + arr[vidx], soset2);
            set1.remove(set1.size() - 1);
        }
        if (set2.size() < (n + 1) / 2) {
            set2.add(arr[vidx]);
            solve(arr, vidx + 1, set1, set2, soset1, soset2 + arr[vidx]);
            set2.remove(set2.size() - 1);
        }

    }
}
