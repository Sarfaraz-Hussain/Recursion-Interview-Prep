import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrintUniqueSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        Set<String> set = new HashSet<String>();
        printUniqueSubsets(ip, set, "");
        for (String str : set) {
            System.out.print(str + " ");
        }
    }

    private static void printUniqueSubsets(String ip, Set<String> set, String op) {
        if (ip.length() == 0) {
            set.add(op);
            return;
        }

        String op1 = op + ip.charAt(0);
        String op2 = op;
        ip = ip.substring(1);
        printUniqueSubsets(ip, set, op1);
        printUniqueSubsets(ip, set, op2);
    }
}