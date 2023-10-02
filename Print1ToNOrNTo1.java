import java.util.Scanner;

public class Print1ToNOrNTo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        print1ToN(n);
        System.out.println();
        printNTo1(n);
    }

    private static void print1ToN(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        print1ToN(n - 1);
        System.out.print(n + " ");
    }

    private static void printNTo1(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        n = n - 1;
    }
}
