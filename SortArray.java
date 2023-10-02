import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 1, 6, 5, 4));
        sort(list);
        System.out.println(list);
    }

    private static void sort(List<Integer> list) {
        if (list.size() == 1)
            return;

        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        sort(list);
        insert(list, temp);
    }

    private static void insert(List<Integer> list, int temp) {
        if (list.size() == 0 || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return;
        }

        int ele = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        insert(list, temp);
        list.add(ele);
    }
}