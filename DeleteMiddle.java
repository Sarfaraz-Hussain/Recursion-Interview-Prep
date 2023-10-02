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
