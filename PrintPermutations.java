import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();

        solve(ip, "");
    }

    private static void solve(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }

        for (int i = 0; i < ip.length(); i++) {
            String op1 = op + ip.charAt(i);
            solve(ip.substring(0, i) + ip.substring(i + 1), op1);
        }
    }
}