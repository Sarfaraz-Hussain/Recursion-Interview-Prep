import java.util.ArrayList;
import java.util.List;

public class GetSubsequence {

    public static void main(String... args) {
        String ip = "abc";
        for (String ele : solve(ip)) {
            System.out.print(ele + " ");
        }
    }

    private static List<String> solve(String ip) {
        if (ip.length() == 0) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        String temp = ip.charAt(0) + "";
        ip = ip.substring(1);
        List<String> ros = solve(ip);
        List<String> ans = new ArrayList<>();
        for (String ele : ros) {
            ans.add(ele);
            ans.add(temp + ele);
        }
        return ans;
    }

}
