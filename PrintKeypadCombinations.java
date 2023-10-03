public class PrintKeypadCombinations {
    public static void main(String[] args) {
        String[] arr = { "?!", "abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz", ".;" };
        String ip = "573";
        solve(ip, arr, "");
    }

    private static void solve(String ip, String[] arr, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }
        int ch = ip.charAt(0) - '0';
        ip = ip.substring(1);

        for (int i = 0; i < arr[ch].length(); i++) {
            String op1 = op + arr[ch].charAt(i);
            solve(ip, arr, op1);
        }
    }
}
