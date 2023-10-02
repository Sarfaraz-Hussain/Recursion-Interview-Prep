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
