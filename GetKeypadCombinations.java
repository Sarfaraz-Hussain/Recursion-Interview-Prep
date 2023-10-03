import java.util.ArrayList;
import java.util.List;

public class GetKeypadCombinations {
    public static void main(String... args) {
        String[] arr = { "?!", "abc", "def", "ghi", "jkl", "mnop", "qrst", "uv", "wxyz", ".;" };
        String ip = "573";
        for (String ele : solve(ip, arr)) {
            System.out.print(ele + " ");
        }
    }

    private static List<String> solve(String ip, String[] arr) {
        if (ip.length() == 0) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        int temp = ip.charAt(0) - '0';
        ip = ip.substring(1);
        List<String> rres = solve(ip, arr);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < arr[temp].length(); i++) {
            char ch = arr[temp].charAt(i);
            for (String ele : rres) {
                ans.add(ch + ele);
            }
        }
        return ans;
    }
}
