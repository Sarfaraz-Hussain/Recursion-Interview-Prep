import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        generateBalancedParentheses(n, n, "");
    }

    private static void generateBalancedParentheses(int close, int open, String op) {
        if (close == 0 && open == 0) {
            System.out.println(op);
            return;
        }
        if (close == open) {
            String op1 = op + "(";
            open--;
            generateBalancedParentheses(close, open, op1);
        } else if (close > open && open != 0) {
            String op1 = op + "(";
            String op2 = op + ")";
            generateBalancedParentheses(close, open - 1, op1);
            generateBalancedParentheses(close - 1, open, op2);
        } else {
            String op1 = op + ")";
            close--;
            generateBalancedParentheses(close, open, op1);
        }
    }
}
