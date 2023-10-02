import java.util.Scanner;

// Here I am assuming ip in lowercase

public class PermutaionWithCaseChange {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        permutaionWithCaseChange(ip, "");
    }

    private static void permutaionWithCaseChange(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }

        String op1 = op + ip.charAt(0);
        String op2 = op + (ip.charAt(0) + "").toUpperCase();
        ip = ip.substring(1);
        permutaionWithCaseChange(ip, op1);
        permutaionWithCaseChange(ip, op2);
    }
}