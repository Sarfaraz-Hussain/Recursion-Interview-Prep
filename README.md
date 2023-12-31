# Recursion and Backtracking

## Java Solutions By Sarfaraz Hussain - Aditya Verma's YouTube Playlist

### *1. Print 1 to N or N to 1 using Recursion*

```java
import java.util.Scanner;

public class Print1ToNOrNTo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        print1ToN(n);
        System.out.println();
        printNTo1(n);
    }

    private static void print1ToN(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        print1ToN(n - 1);
        System.out.print(n + " ");
    }

    private static void printNTo1(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printNTo1(n - 1);
    }
}
```

---

### *2. Calculate Height of Binary Tree using Recursion*

```java
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class HeightOfTree {
    public static void main(String[] args) {
        /* Example Tree
            10
           / \
          20 30
         / \
        40 50
          /
         60
        */
        // height of above tree is 4

        // Tree input
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(60);

        System.out.println(height(root));
    }

    private static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
```

---

### *3. Sort an Array using Recursion*

```java
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
```

---

### *4. Sort a Stack using Recursion*

```java
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        sort(stack);
        System.out.println(stack.toString());
    }

    private static void sort(Stack<Integer> stack) {
        if (stack.size() == 1)
            return;

        int temp = stack.pop();
        sort(stack);
        insert(stack, temp);
    }

    private static void insert(Stack<Integer> stack, int temp) {
        if (stack.size() == 1 || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        int ele = stack.pop();
        insert(stack, temp);
        stack.push(ele);
    }
}
```

---

### *5. Delete Middle Element from Stack using Recursion*

```java
import java.util.Stack;

public class DeleteMiddle {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        delete(stack, stack.size() / 2 + 1);  // Middle Definition k = size / 2 + 1
        System.out.println(stack.toString());
    }

    private static void delete(Stack<Integer> stack, int k) {
        if (stack.size() == 0)
            return;
        if (k == 1) {
            stack.pop();
            return;
        }

        int temp = stack.pop();
        delete(stack, k - 1);
        stack.push(temp);
    }
}
```

---

### *6. Reverse a Stack using Recursion*

```java
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println("Before Reverse: ");
        System.out.println(stack);
        reverse(stack);
        System.out.println("After Reverse: ");
        System.out.println(stack);
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.size() == 0)
            return;

        int temp = stack.pop();
        reverse(stack);
        insert(stack, temp);
    }

    private static void insert(Stack<Integer> stack, int temp) {
        if(stack.size() == 0)
        {
            stack.push(temp);
            return;
        }

        int ele = stack.pop();
        insert(stack, temp);
        stack.push(ele);
    }
}
```

---

### *7. Find kth Symbol in a Grammer*

```java
import java.util.Scanner;

public class KthSymbolGrammer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        System.out.println(findKthSymbolInGrammer(N, K));
    }

    private static int findKthSymbolInGrammer(int N, int K) {
        if (N == 1 && K == 1)
            return 0;
        int length = (int) Math.pow(2, N - 1);
        int mid = length / 2;
        if (K <= mid)
            return findKthSymbolInGrammer(N - 1, K);
        else
            return findKthSymbolInGrammer(N - 1, K - mid) ^ 1;
    }
}
```

---

### *8. Tower of Hanoi*

```java
import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        toh(n, 'S', 'H', 'D');
    }

    private static void toh(int n, char S, char H, char D) {
        if (n == 0)
            return;
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + S + " to " + D);
            return;
        }
        toh(n - 1, S, D, H);
        System.out.println("Move disc " + n + " from " + S + " to " + D);
        toh(n - 1, H, S, D);
    }
}
```

---

### *9.Print Subsets | Subsequences | Power Set of a String*

```java
import java.util.Scanner;

public class PrintSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        printSubsets(ip, "");
    }

    private static void printSubsets(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }

        String op1 = op + ip.charAt(0); // include
        String op2 = op; // exclude
        ip = ip.substring(1);
        printSubsets(ip, op1);
        printSubsets(ip, op2);

    }
}
```

---

### *10. Print Unique Subsets or Unique Subsequences*

```java
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrintUniqueSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        Set<String> set = new HashSet<String>();
        printUniqueSubsets(ip, set, "");
        for (String str : set) {
            System.out.print(str + " ");
        }
    }

    private static void printUniqueSubsets(String ip, Set<String> set, String op) {
        if (ip.length() == 0) {
            set.add(op);
            return;
        }

        String op1 = op + ip.charAt(0);
        String op2 = op;
        ip = ip.substring(1);
        printUniqueSubsets(ip, set, op1);
        printUniqueSubsets(ip, set, op2);
    }
}
```

---

### *11. Permutations with Spaces(_)*

```java
import java.util.Scanner;

public class PermutationsWithSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        String op = ip.charAt(0) + "";
        printPermutationWithSpaces(ip.substring(1), op);
    }

    private static void printPermutationWithSpaces(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }

        String op1 = op + ip.charAt(0);
        String op2 = op + "_" + ip.charAt(0);
        ip = ip.substring(1);
        printPermutationWithSpaces(ip, op1);
        printPermutationWithSpaces(ip, op2);
    }
}
```

---

### *12. Permutation with Case change (Assuming input is in lowercase)*

```java
import java.util.Scanner;

// Here I am assuming input is in lowercase

public class PermutaionWithCaseChange {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        permutaionWithCaseChange(ip, "");
    }

    private static void permutaionWithCaseChange(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }

        String op1 = op + ip.charAt(0);
        String op2 = op + (ip.charAt(0) + "").toUpperCase();
        ip = ip.substring(1);
        permutaionWithCaseChange(ip, op1);
        permutaionWithCaseChange(ip, op2);
    }
}
```

---

### *13. Letter Case Permutation where.....*

- *Lowercase letter need not be neccessary*
- *Digits are allowed*

```java
import java.util.Scanner;

public class LetterCasePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        printLetterCasePermutation(ip, "");
    }

    private static void printLetterCasePermutation(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }
        if (ip.charAt(0) >= 48 && ip.charAt(0) <= 57) {
            String op1 = op + ip.charAt(0);
            ip = ip.substring(1);
            printLetterCasePermutation(ip, op1);
        } else {
            String op1 = "";
            String op2 = "";
            if (ip.charAt(0) >= 65 && ip.charAt(0) <= 90) {
                op1 = op + (ip.charAt(0) + "").toLowerCase();
                op2 = op + ip.charAt(0);
            } else {
                op1 = op + (ip.charAt(0) + "").toUpperCase();
                op2 = op + ip.charAt(0);
            }
            ip = ip.substring(1);
            printLetterCasePermutation(ip, op1);
            printLetterCasePermutation(ip, op2);
        }
    }
}
```

---

### *14. Generate All Balanced Parentheses*

```java
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        generateBalancedParentheses(n, n, "");
    }

    private static void generateBalancedParentheses(int close, int open, String op) {
        if (close == 0 && open == 0) {
            System.out.println(op);
            return;
        }
        if (close == open) {
            String op1 = op + "(";
            open--;
            generateBalancedParentheses(close, open, op1);
        } else if (close > open && open != 0) {
            String op1 = op + "(";
            String op2 = op + ")";
            generateBalancedParentheses(close, open - 1, op1);
            generateBalancedParentheses(close - 1, open, op2);
        } else {
            String op1 = op + ")";
            close--;
            generateBalancedParentheses(close, open, op1);
        }
    }
}
```

---

### *15. Print N Bit Binary Numbers having #of 1's >= #of 0's*

```java
import java.util.Scanner;

public class PrintNBitBinaryNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        printNBitBinaryNumbers(0, 0, "", n);
    }

    private static void printNBitBinaryNumbers(int zeros, int ones, String op, int n) {
    
        if ((zeros + ones) == n) {
            System.out.println(op);
            return;
        }

        if (zeros == ones) {
            String op1 = op + "1";
            printNBitBinaryNumbers(zeros, ones + 1, op1, n);
        } else if (ones > zeros) {
            String op1 = op + "1";
            String op2 = op + "0";
            printNBitBinaryNumbers(zeros, ones + 1, op1, n);
            printNBitBinaryNumbers(zeros + 1, ones, op2, n);
        }
    }
}
```

---

### *15. Josephus Problem using Recursion*

```java
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

```

---

## Java Solutions By Sarfaraz Hussain - Pepcoding Recursion YouTube Playlist Level 1

### *16. First Index of Occurrance in array*

```java
public class FirstIndex {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 9, 8, 7, 6, 4, 7, 12, 7, 3, 8 };
        int x = 7;
        System.out.println(find(arr, x, 0));
    }

    private static int find(int[] arr, int x, int k) {
        if (arr[k] == x)
            return k;
        if (k == arr.length - 1)
            return -1;
        return find(arr, x, k + 1);
    }
}
```

---

### *17. Last Index of Occurrance in array*

```java
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
```

---

### *18. All Index of Occurrance in array*

```java
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
```

---

### *19. Get Subsequences (return an array)*

```java
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

```

---

### *20. Get Keypad Combinations (return an array)*

```java
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

```

---

### *21. Get Stair Paths (return an array)*

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetStairPaths {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for (String ans : solve(n)) {
            System.out.print(ans + " ");
        }
    }

    private static List<String> solve(int n) {
        if (n == 0) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        if (n < 0) {
            List<String> bres = new ArrayList<>();
            return bres;
        }

        List<String> one = solve(n - 1);
        List<String> two = solve(n - 2);
        List<String> three = solve(n - 3);

        List<String> ans = new ArrayList<>();

        for (String ele : one) {
            ans.add("1" + ele);
        }

        for (String ele : two) {
            ans.add("2" + ele);
        }

        for (String ele : three) {
            ans.add("3" + ele);
        }

        return ans;
    }
}

```

---

### *22. Get Maze Paths (return an array)*

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        int[][] maze = new int[n][m];
        for (String ans : solve(maze, 0, 0)) {
            System.out.print(ans + " ");
        }
    }

    private static List<String> solve(int[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        if (row == maze.length || col == maze[0].length) {
            List<String> bres = new ArrayList<>();
            return bres;
        }

        List<String> hpaths = solve(maze, row, col + 1);
        List<String> vpaths = solve(maze, row + 1, col);
        List<String> paths = new ArrayList<>();

        for (String path : hpaths) {
            paths.add("h" + path);
        }

        for (String path : vpaths) {
            paths.add("v" + path);
        }

        return paths;
    }
}

```

---

### *23. Get Maze Paths with Jumps (return an array)*

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetMazePathsWithJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        for (String path : solve(1, 1, n, m)) {
            System.out.print(path + " ");
        }
    }

    private static List<String> solve(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        List<String> paths = new ArrayList<>();

        for (int ms = 1; ms <= dc - sc; ms++) {
            List<String> hpaths = solve(sr, sc + ms, dr, dc);
            for (String path : hpaths) {
                paths.add("h" + ms + path);
            }
        }

        for (int ms = 1; ms <= dr - sr; ms++) {
            List<String> vpaths = solve(sr + ms, sc, dr, dc);
            for (String path : vpaths) {
                paths.add("v" + ms + path);
            }

        }

        for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            List<String> dpaths = solve(sr + ms, sc + ms, dr, dc);
            for (String path : dpaths) {
                paths.add("d" + ms + path);
            }
        }
        return paths;
    }
}

```

---

### *24. Print Keypad Combinations*

```java
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


```

---

### *25. Print Stair Paths*

```java
import java.util.Scanner;

public class PrintStairPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        solve(n, "");
    }

    private static void solve(int n, String op) {
        if (n == 0) {
            System.out.print(op + " ");
            return;
        }
        if (n < 0) {
            return;
        }

        for (int js = 1; js <= 3; js++) {
            String op1 = op + js;
            solve(n - js, op1);
        }
    }
}

```

---

### *26. Print Maze Paths*

```java
import java.util.Scanner;

public class PrintMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        solve(new int[n][m], 0, 0, "");
    }

    private static void solve(int[][] maze, int row, int col, String op) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.print(op + " ");
            return;
        }

        if (row == maze.length || col == maze[0].length) {
            return;
        }

        String op1 = op + "h";
        String op2 = op + "v";
        solve(maze, row, col + 1, op1);
        solve(maze, row + 1, col, op2);
    }
}

```

---

### *27. Print Maze Paths with jumps*

```java
import java.util.Scanner;

public class PrintMazePathsWithjumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        solve(1, 1, n, m, "");
    }

    private static void solve(int sr, int sc, int dr, int dc, String op) {
        if (sr == dr && sc == dc) {
            System.out.print(op + " ");
            return;
        }

        for (int ms = 1; ms <= dc - sc; ms++) {
            String op1 = op + "h" + ms;
            solve(sr, sc + ms, dr, dc, op1);
        }

        for (int ms = 1; ms <= dr - sr; ms++) {
            String op1 = op + "v" + ms;
            solve(sr + ms, sc, dr, dc, op1);
        }

        for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            String op1 = op + "d" + ms;
            solve(sr + ms, sc + ms, dr, dc, op1);
        }
    }
}

```

---

### *28. Print Permutations*

```java
import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();

        solve(ip, "");
    }

    private static void solve(String ip, String op) {
        if (ip.length() == 0) {
            System.out.print(op + " ");
            return;
        }

        for (int i = 0; i < ip.length(); i++) {
            String op1 = op + ip.charAt(i);
            solve(ip.substring(0, i) + ip.substring(i + 1), op1);
        }
    }
}
```

---

### *29. Print Encodings*

```java
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

```

---

### *30. Flood Fill*

```java
import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        sc.close();
        boolean[][] visited = new boolean[n][m];
        solve(maze, 0, 0, "", visited);
    }

    private static void solve(int[][] maze, int row, int col, String op, boolean[][] visited) {
        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1
                || visited[row][col] == true) {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.print(op + " ");
            return;
        }

        visited[row][col] = true;
        solve(maze, row - 1, col, op + "t", visited);
        solve(maze, row, col - 1, op + "l", visited);
        solve(maze, row + 1, col, op + "d", visited);
        solve(maze, row, col + 1, op + "r", visited);
        visited[row][col] = false;
    }
}

```

---

### *31. Target Sum Subsets*

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetSumSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int sum = sc.nextInt();
        sc.close();
        solve(arr, n - 1, sum, new ArrayList<Integer>());
    }

    private static void solve(int[] arr, int index, int sum, List<Integer> op) {
        if (index == -1) {
            if (sum == 0) {
                System.out.println(op.toString());
            }
            return;
        }

        if (sum >= arr[index]) {
            List<Integer> op1 = new ArrayList<>();
            op1.addAll(op); 
            op1.add(arr[index]);
            solve(arr, index - 1, sum - arr[index], op1);
            solve(arr, index - 1, sum, op);
        } else {
            solve(arr, index - 1, sum, op);
        }
    }
}

```

---

### *32. N Queens*

```java
import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[][] chess = new int[N][N];
        solve(chess, 0, "");
    }

    private static void solve(int[][] chess, int row, String op) {
        if (chess.length == row) {
            System.out.println(op);
            return;
        }

        for (int col = 0; col < chess[0].length; col++) {
            if (isItSafePositionForQueenToBePlace(chess, row, col)) {
                chess[row][col] = 1;
                solve(chess, row + 1, op + row + "-" + col + " ");
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isItSafePositionForQueenToBePlace(int[][] chess, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--)
            if (chess[i][j] == 1)
                return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chess[i][j] == 1)
                return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++)
            if (chess[i][j] == 1)
                return false;
        return true;
    }
}

```

---

### *33. Knights Tour*

```java
import java.util.Scanner;

public class KnightsTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        int[][] chess = new int[N][N];

        printKnightsTour(chess, r, c, 1);

    }

    private static void printKnightsTour(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0)
            return;
        if (move == chess.length * chess.length) {
            chess[r][c] = move;
            displayBoard(chess);
            System.out.println();
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = move;
        printKnightsTour(chess, r - 2, c + 1, move + 1);
        printKnightsTour(chess, r - 1, c + 2, move + 1);
        printKnightsTour(chess, r + 1, c + 1, move + 1);
        printKnightsTour(chess, r + 2, c + 1, move + 1);
        printKnightsTour(chess, r + 2, c - 1, move + 1);
        printKnightsTour(chess, r + 1, c - 2, move + 1);
        printKnightsTour(chess, r - 1, c - 2, move + 1);
        printKnightsTour(chess, r - 2, c - 1, move + 1);
        chess[r][c] = 0;
    }

    private static void displayBoard(int[][] chess) {
        for (int[] row : chess) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}

```

---

## Java Solutions By Sarfaraz Hussain - Pepcoding Recursion YouTube Playlist Level 2

### *34. Print Abbreviations*

```java
import java.util.Scanner;

public class PrintAbbreviations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        solve(ip, "", 0);
    }

    private static void solve(String ip, String op, int count) {
        if (ip.length() == 0) {
            if (count != 0)
                System.out.println(op + count);
            else
                System.out.println(op);
            return;
        }

        char ch = ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, op, count + 1);
        if (count != 0)
            solve(ip, op + count + ch, 0);
        else
            solve(ip, op + ch, 0);
    }
}

```

---

### *35. N Queens using Branch and Bounds*

```java
import java.util.Scanner;

public class NQueenUsingBranchAndBound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[][] chess = new int[N][N];
        boolean[] cols = new boolean[N];
        boolean[] md = new boolean[2 * N - 1];
        boolean[] ad = new boolean[2 * N - 1];
        solve(chess, cols, md, ad, N, 0, "");
    }

    private static void solve(int[][] chess, boolean[] cols, boolean[] md, boolean[] ad, int N, int row, String op) {
        if (row == chess.length) {
            System.out.println(op);
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (cols[col] == false && md[row + col] == false && ad[row - col + N - 1] == false) {
                chess[row][col] = 1;
                cols[col] = md[row + col] = ad[row - col + N - 1] = true;
                solve(chess, cols, md, ad, N, row + 1, op + row + "-" + col + " ");
                chess[row][col] = 0;
                cols[col] = md[row + col] = ad[row - col + N - 1] = false;
            }
        }
    }
}

```

---

### *36. Max Score of words*

```java
import java.util.Scanner;

public class MaxScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        int nofLetters = sc.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = sc.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < 26; i++) {
            score[i] = sc.nextInt();
        }
        sc.close();
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[26];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(maxScore(words, farr, score, 0));
    }

    private static int maxScore(String[] words, int[] farr, int[] score, int idx) {

        if (idx == words.length) {
            return 0;
        }

        int sno = 0 + maxScore(words, farr, score, idx + 1);

        String word = words[idx];
        int sword = 0;
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (farr[ch - 'a'] == 0) {
                flag = false;
            }
            farr[ch - 'a']--;
            sword += score[ch - 'a'];
        }
        int syes = 0;
        if (flag) {
            syes = sword + maxScore(words, farr, score, idx + 1);
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }
        return Math.max(sno, syes);
    }
}

```

---

### *37. Print Lexicographical Order*

```java
import java.util.Scanner;

public class PrintLexicographicalOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
    }

    private static void dfs(int i, int n) {
        if (i > n)
            return;

        System.out.print(i + " ");
        for (int j = 0; j <= 9; j++) {
            dfs(10 * i + j, n);
        }
    }
}

```

---

### *38. Gold Mine 2*

```java
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

```

---

### *39. Sudoku Solver*

```java
import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        sc.close();
        sudokuSolver(board, 0, 0);
    }

    private static void sudokuSolver(int[][] board, int i, int j) {
        if (i == board.length) {
            System.out.println("The Solution is following::");
            display(board);
            return;
        }
        int ni = 0;
        int nj = 0;

        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != 0) {
            sudokuSolver(board, ni, nj);
        } else {
            for (int po = 1; po <= 9; po++) {
                if (isValid(board, i, j, po) == true) {
                    board[i][j] = po;
                    sudokuSolver(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static void display(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int[][] board, int x, int y, int val) {

        for (int j = 0; j < board[0].length; j++) {
            if (board[x][j] == val)
                return false;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[i][y] == val)
                return false;
        }

        int sRow = 3 * (x / 3);
        int sCol = 3 * (y / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + sRow][j + sCol] == val)
                    return false;
            }
        }
        return true;
    }
}

```

---

### *40. Crossword Puzzle*

```java
import java.util.Scanner;

public class CrosswordPuzzle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        scn.close();
        solution(arr, words, 0);
    }

    private static void solution(char[][] arr, String[] words, int vidx) {

        if (vidx == words.length) {
            System.out.println();
            print(arr);
            return;
        }

        String word = words[vidx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (canPlaceWordHorizontally(arr, word, i, j)) {
                        boolean[] flag = placeWordHorizontally(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceWordHorizontally(arr, word, i, j, flag);
                    }

                    if (canPlaceWordVertically(arr, word, i, j)) {
                        boolean[] flag = placeWordVertically(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceWordVertically(arr, word, i, j, flag);
                    }
                }
            }
        }
    }

    private static void unplaceWordVertically(char[][] arr, String word, int i, int j, boolean[] flag) {
        for (int ii = 0; ii < word.length(); ii++) {
            if (flag[ii]) {
                arr[i + ii][j] = '-';
            }
        }
    }

    private static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
        boolean[] flag = new boolean[word.length()];
        for (int ii = 0; ii < word.length(); ii++) {
            if (arr[i + ii][j] == '-') {
                arr[i + ii][j] = word.charAt(ii);
                flag[ii] = true;
            }
        }
        return flag;
    }

    private static void unplaceWordHorizontally(char[][] arr, String word, int i, int j, boolean[] flag) {
        for (int jj = 0; jj < word.length(); jj++) {
            if (flag[jj]) {
                arr[i][j + jj] = '-';
            }
        }
    }

    private static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
        boolean[] flag = new boolean[word.length()];
        for (int jj = 0; jj < word.length(); jj++) {
            if (arr[i][j + jj] == '-') {
                arr[i][j + jj] = word.charAt(jj);
                flag[jj] = true;
            }
        }
        return flag;
    }

    private static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {
        if (i - 1 >= 0 && arr[i - 1][j] != '+') {
            return false;
        } else if (i + word.length() < arr.length && arr[i + word.length()][j] != '+') {
            return false;
        }

        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= arr.length)
                return false;

            if (arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii)) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    private static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j) {

        if (j - 1 >= 0 && arr[i][j - 1] != '+') {
            return false;
        } else if (j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') {
            return false;
        }

        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= arr[0].length)
                return false;

            if (arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    private static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

```

---

### *41. Cryptarithmetic Puzzle*

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CryptarithmeticPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        sc.close();

        String uniqueString = "";
        Map<Character, Integer> charIntMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                uniqueString += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                uniqueString += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                uniqueString += s3.charAt(i);
            }
        }

        solution(uniqueString, 0, charIntMap, new boolean[10], s1, s2, s3);
    }

    private static void solution(String uniqueString, int idx, Map<Character, Integer> charIntMap,
            boolean[] usedNumbers,
            String s1, String s2, String s3) {

        if (idx == uniqueString.length()) {
            int num1 = getNum(s1, charIntMap);
            int num2 = getNum(s2, charIntMap);
            int num3 = getNum(s3, charIntMap);

            if (num1 + num2 == num3) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) ('a' + i);
                    if (charIntMap.containsKey(ch)) {
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                    }
                }
                System.out.println();
            }
            return;
        }

        char ch = uniqueString.charAt(idx);
        for (int num = 0; num <= 9; num++) {
            if (usedNumbers[num] == false) {
                usedNumbers[num] = true;
                charIntMap.put(ch, num);
                solution(uniqueString, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
                usedNumbers[num] = false;
                charIntMap.put(ch, -1);
            }
        }
    }

    private static int getNum(String str, Map<Character, Integer> charIntMap) {

        String num = "";
        for (int i = 0; i < str.length(); i++) {
            num += charIntMap.get(str.charAt(i));
        }
        return Integer.parseInt(num);
    }
}

```

---

### *42. Friends Pairing*

```java
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

```

---