import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        toh(n, 'S', 'H', 'D');
    }

    private static void toh(int n, char S, char H, char D) {
        if (n == 0)
            return;
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + S + " to " + D);
            return;
        }
        toh(n - 1, S, D, H);
        System.out.println("Move disc " + n + " from " + S + " to " + D);
        toh(n - 1, H, S, D);
    }
}
