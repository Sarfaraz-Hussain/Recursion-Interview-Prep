import java.util.Scanner;

public class PrintNBitBinaryNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        printNBitBinaryNumbers(0, 0, "", n);
    }

    private static void printNBitBinaryNumbers(int zeros, int ones, String op, int n) {
    
        if ((zeros + ones) == n) {
            System.out.println(op);
            return;
        }

        if (zeros == ones) {
            String op1 = op + "1";
            printNBitBinaryNumbers(zeros, ones + 1, op1, n);
        } else if (ones > zeros) {
            String op1 = op + "1";
            String op2 = op + "0";
            printNBitBinaryNumbers(zeros, ones + 1, op1, n);
            printNBitBinaryNumbers(zeros + 1, ones, op2, n);
        }
    }
}