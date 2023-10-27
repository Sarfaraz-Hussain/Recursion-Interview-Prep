import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        solve(str, getMin(str), new HashSet<>());
    }

    private static void solve(String str, int mra, HashSet<String> ans) {
        if (mra == 0) {
            if (getMin(str) == 0 && !ans.contains(str)) {
                ans.add(str);
                System.out.println(str);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1);
            solve(newStr, mra - 1, ans);
        }

    }

    private static int getMin(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.size() == 0 || stack.peek() == ')') {
                    stack.push(ch);
                } else if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}
