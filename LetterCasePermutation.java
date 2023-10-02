import java.util.Scanner;

public class LetterCasePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        printLetterCasePermutation(ip, "");
    }

    private static void printLetterCasePermutation(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }
        if (ip.charAt(0) >= 48 && ip.charAt(0) <= 57) {
            String op1 = op + ip.charAt(0);
            ip = ip.substring(1);
            printLetterCasePermutation(ip, op1);
        } else {
            String op1 = "";
            String op2 = "";
            if (ip.charAt(0) >= 65 && ip.charAt(0) <= 90) {
                op1 = op + (ip.charAt(0) + "").toLowerCase();
                op2 = op + ip.charAt(0);
            } else {
                op1 = op + (ip.charAt(0) + "").toUpperCase();
                op2 = op + ip.charAt(0);
            }
            ip = ip.substring(1);
            printLetterCasePermutation(ip, op1);
            printLetterCasePermutation(ip, op2);
        }
    }
}