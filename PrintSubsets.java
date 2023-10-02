import java.util.Scanner;

public class PrintSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        printSubsets(ip, "");
    }

    private static void printSubsets(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }

        String op1 = op + ip.charAt(0);
        String op2 = op;
        ip = ip.substring(1);
        printSubsets(ip, op1);
        printSubsets(ip, op2);

    }
}