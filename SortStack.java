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
