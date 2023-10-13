import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CryptarithmeticPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        sc.close();

        String uniqueString = "";
        Map<Character, Integer> charIntMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                uniqueString += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                uniqueString += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                uniqueString += s3.charAt(i);
            }
        }

        solution(uniqueString, 0, charIntMap, new boolean[10], s1, s2, s3);
    }

    private static void solution(String uniqueString, int idx, Map<Character, Integer> charIntMap,
            boolean[] usedNumbers,
            String s1, String s2, String s3) {

        if (idx == uniqueString.length()) {
            int num1 = getNum(s1, charIntMap);
            int num2 = getNum(s2, charIntMap);
            int num3 = getNum(s3, charIntMap);

            if (num1 + num2 == num3) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) ('a' + i);
                    if (charIntMap.containsKey(ch)) {
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                    }
                }
                System.out.println();
            }
            return;
        }

        char ch = uniqueString.charAt(idx);
        for (int num = 0; num <= 9; num++) {
            if (usedNumbers[num] == false) {
                usedNumbers[num] = true;
                charIntMap.put(ch, num);
                solution(uniqueString, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
                usedNumbers[num] = false;
                charIntMap.put(ch, -1);
            }
        }
    }

    private static int getNum(String str, Map<Character, Integer> charIntMap) {

        String num = "";
        for (int i = 0; i < str.length(); i++) {
            num += charIntMap.get(str.charAt(i));
        }
        return Integer.parseInt(num);
    }
}