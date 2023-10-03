public class PrintEncodings {
    public static void main(String[] args) {
        char[] arr = " abcdefghijklmnopqrstuvwxyz".toCharArray();
        String ip = "123";
        solve(ip, "", arr);
    }

    private static void solve(String ip, String op, char[] arr) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }

        int a, b;
        a = b = Integer.MAX_VALUE;
        a = ip.charAt(0) - '0';
        if (ip.length() > 1) {
            b = Integer.parseInt(ip.substring(0, 2));
        }

        if (a >= 1 && b <= 26) {
            String op1 = op + arr[a];
            String op2 = op + arr[b];
            solve(ip.substring(1), op1, arr);
            solve(ip.substring(2), op2, arr);
        } else if (a > 0) {
            String op1 = op + arr[a];
            solve(ip.substring(1), op1, arr);
        }
    }
}
