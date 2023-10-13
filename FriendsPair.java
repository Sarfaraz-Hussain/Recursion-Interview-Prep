import java.util.Scanner;

public class FriendsPair {
    static int counter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        boolean[] used = new boolean[n + 1];
        solution(1, n, used, "");
    }

    private static void solution(int i, int n, boolean[] used, String op) {

        if (i > n) {
            System.out.println(counter + "." + op);
            counter++;
            return;
        }

        if (used[i] == true) {
            solution(i + 1, n, used, op);
        } else {
            used[i] = true;
            solution(i + 1, n, used, op + "(" + i + ") ");
            for (int j = i + 1; j <= n; j++) {
                if (used[j] == false) {
                    used[j] = true;
                    solution(i + 1, n, used, op + "(" + i + "," + j + ") ");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }
}
