import java.util.Scanner;

public class KthSymbolGrammer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        System.out.println(findKthSymbolInGrammer(N, K));
    }

    private static int findKthSymbolInGrammer(int N, int K) {
        if (N == 1 && K == 1)
            return 0;
        int length = (int) Math.pow(2, N - 1);
        int mid = length / 2;
        if (K <= mid)
            return findKthSymbolInGrammer(N - 1, K);
        else
            return findKthSymbolInGrammer(N - 1, K - mid) ^ 1;
    }
}
