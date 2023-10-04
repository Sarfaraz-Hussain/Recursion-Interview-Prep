import java.util.Scanner;

public class PrintAbbreviations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        solve(ip, "", 0);
    }

    private static void solve(String ip, String op, int count) {
        if (ip.length() == 0) {
            if (count != 0)
                System.out.println(op + count);
            else
                System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, op, count + 1);
        if (count != 0)
            solve(ip, op + count + ch, 0);
        else
            solve(ip, op + ch, 0);
    }
}
