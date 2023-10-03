import java.util.ArrayList;
import java.util.List;

public class AllOccurance {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 9, 8, 7, 6, 4, 7, 12, 7, 3, 8 };
        int x = 7;
        List<Integer> ans = find(arr, x, 0, new ArrayList<>());
        if (ans.size() == 0)
            System.out.println(-1);
        else
            for (Integer ele : ans) {
                System.out.print(ele + " ");
            }
    }

    private static List<Integer> find(int[] arr, int x, int k, List<Integer> list) {
        if (k == arr.length)
            return list;
        if (arr[k] == x)
            list.add(k);
        return find(arr, x, k + 1, list);
    }
}
