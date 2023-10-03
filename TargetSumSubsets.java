import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetSumSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int sum = sc.nextInt();
        sc.close();
        solve(arr, n - 1, sum, new ArrayList<Integer>());
    }

    private static void solve(int[] arr, int index, int sum, List<Integer> op) {
        if (index == -1) {
            if (sum == 0) {
                System.out.println(op.toString());
            }
            return;
        }

        if (sum >= arr[index]) {
            List<Integer> op1 = new ArrayList<>();
            op1.addAll(op); 
            op1.add(arr[index]);
            solve(arr, index - 1, sum - arr[index], op1);
            solve(arr, index - 1, sum, op);
        } else {
            solve(arr, index - 1, sum, op);
        }
    }
}
