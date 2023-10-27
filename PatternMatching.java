import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class PatternMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ptr = sc.next();
        String str = sc.next();
        sc.close();

        Map<Character, String> map = new HashMap<>();
        solve(str, ptr, map, ptr);
    }

    private static void solve(String str, String ptr, Map<Character, String> map, String op) {

        if (ptr.length() == 0) {
            if (str.length() == 0) {
                HashSet<Character> alreadyPrinted = new HashSet<>();
                for (int i = 0; i < op.length(); i++) {
                    char ch = op.charAt(i);
                    if (!alreadyPrinted.contains(ch)) {
                        System.out.print(ch + "->" + map.get(ch) + " ");
                        alreadyPrinted.add(ch);
                    }
                }
                System.out.println();
            }
            return;
        }

        char ch = ptr.charAt(0);
        String rop = ptr.substring(1);

        if (map.containsKey(ch)) {
            String previousMapping = map.get(ch);
            if (str.length() >= previousMapping.length()) {
                String left = str.substring(0, previousMapping.length());
                String right = str.substring(previousMapping.length());
                if (previousMapping.equals(left))
                    solve(right, rop, map, op);
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);
                map.put(ch, left);
                solve(right, rop, map, op);
                map.remove(ch);

            }
        }

    }
}
