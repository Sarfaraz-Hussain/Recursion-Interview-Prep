import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        boolean[][] visited = new boolean[n][m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0 && visited[i][j] == false) {
                    List<Integer> bag = new ArrayList<>();
                    travelAndCollectGold(arr, i, j, visited, bag);
                    int sum = 0;
                    for (Integer gold : bag)
                        sum += gold;
                    max = Math.max(sum, max);
                }
            }
        }
        System.out.println(max);
    }

    private static void travelAndCollectGold(int[][] arr, int i, int j, boolean[][] visited, List<Integer> bag) {

        if (i < 0 || j < 0 || i == arr.length || j == arr[0].length || arr[i][j] == 0 || visited[i][j] == true)
            return;

        visited[i][j] = true;
        bag.add(arr[i][j]);
        travelAndCollectGold(arr, i - 1, j, visited, bag);
        travelAndCollectGold(arr, i, j + 1, visited, bag);
        travelAndCollectGold(arr, i, j - 1, visited, bag);
        travelAndCollectGold(arr, i + 1, j, visited, bag);
    }
}
