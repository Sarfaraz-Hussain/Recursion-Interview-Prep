import java.util.Scanner;

public class CrosswordPuzzle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        scn.close();
        solution(arr, words, 0);
    }

    private static void solution(char[][] arr, String[] words, int vidx) {

        if (vidx == words.length) {
            System.out.println();
            print(arr);
            return;
        }

        String word = words[vidx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (canPlaceWordHorizontally(arr, word, i, j)) {
                        boolean[] flag = placeWordHorizontally(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceWordHorizontally(arr, word, i, j, flag);
                    }

                    if (canPlaceWordVertically(arr, word, i, j)) {
                        boolean[] flag = placeWordVertically(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceWordVertically(arr, word, i, j, flag);
                    }
                }
            }
        }
    }

    private static void unplaceWordVertically(char[][] arr, String word, int i, int j, boolean[] flag) {
        for (int ii = 0; ii < word.length(); ii++) {
            if (flag[ii]) {
                arr[i + ii][j] = '-';
            }
        }
    }

    private static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
        boolean[] flag = new boolean[word.length()];
        for (int ii = 0; ii < word.length(); ii++) {
            if (arr[i + ii][j] == '-') {
                arr[i + ii][j] = word.charAt(ii);
                flag[ii] = true;
            }
        }
        return flag;
    }

    private static void unplaceWordHorizontally(char[][] arr, String word, int i, int j, boolean[] flag) {
        for (int jj = 0; jj < word.length(); jj++) {
            if (flag[jj]) {
                arr[i][j + jj] = '-';
            }
        }
    }

    private static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
        boolean[] flag = new boolean[word.length()];
        for (int jj = 0; jj < word.length(); jj++) {
            if (arr[i][j + jj] == '-') {
                arr[i][j + jj] = word.charAt(jj);
                flag[jj] = true;
            }
        }
        return flag;
    }

    private static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {
        if (i - 1 >= 0 && arr[i - 1][j] != '+') {
            return false;
        } else if (i + word.length() < arr.length && arr[i + word.length()][j] != '+') {
            return false;
        }

        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= arr.length)
                return false;

            if (arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii)) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    private static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j) {

        if (j - 1 >= 0 && arr[i][j - 1] != '+') {
            return false;
        } else if (j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') {
            return false;
        }

        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= arr[0].length)
                return false;

            if (arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    private static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
