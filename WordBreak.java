import java.util.HashSet;
import java.util.Scanner;

public class WordBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> words = new HashSet<>();
        for (int i = 0; i < n; i++) {
            words.add(sc.next());
        }
        String str = sc.next();
        sc.close();

        solve(str, words, "");
    }

    private static void solve(String str, HashSet<String> words, String op) {

        if (str.length() == 0) {
            System.out.println(op);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            if (words.contains(word)) {
                op = op + word + " ";
                solve(ros, words, op);
            }

        }
    }
}
