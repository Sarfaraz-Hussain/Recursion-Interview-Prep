import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        System.out.println(solveJosephus(k, 0, list));
    }

    private static int solveJosephus(int k, int index, List<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        index = (index + k - 1) % list.size();
        list.remove(index);
        return solveJosephus(k, index, list);
    }
}
