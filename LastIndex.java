public class LastIndex {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 9, 8, 7, 6, 4, 7, 12, 7, 3, 8 };
        int x = 7;
        System.out.println(find(arr, x, arr.length - 1));
    }

    private static int find(int[] arr, int x, int k) {
        if (k == -1)
            return -1;
        if (arr[k] == x)
            return k;
        if (k == 0)
            return -1;
        return find(arr, x, k - 1);
    }
}
