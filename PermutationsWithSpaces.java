import java.util.Scanner;

public class PermutationsWithSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        String op = ip.charAt(0) + "";
        printPermutationWithSpaces(ip.substring(1), op);
    }

    private static void printPermutationWithSpaces(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }

        String op1 = op + ip.charAt(0);
        String op2 = op + "_" + ip.charAt(0);
        ip = ip.substring(1);
        printPermutationWithSpaces(ip, op1);
        printPermutationWithSpaces(ip, op2);
    }
}
