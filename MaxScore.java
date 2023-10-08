import java.util.Scanner;

public class MaxScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        int nofLetters = sc.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = sc.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < 26; i++) {
            score[i] = sc.nextInt();
        }
        sc.close();
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[26];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(maxScore(words, farr, score, 0));
    }

    private static int maxScore(String[] words, int[] farr, int[] score, int idx) {

        if (idx == words.length) {
            return 0;
        }

        int sno = 0 + maxScore(words, farr, score, idx + 1);

        String word = words[idx];
        int sword = 0;
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (farr[ch - 'a'] == 0) {
                flag = false;
            }
            farr[ch - 'a']--;
            sword += score[ch - 'a'];
        }
        int syes = 0;
        if (flag) {
            syes = sword + maxScore(words, farr, score, idx + 1);
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }
        return Math.max(sno, syes);
    }
}
