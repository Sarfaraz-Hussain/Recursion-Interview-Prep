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
        /*
         * Ex. Tree
         * 10
         * / \
         * 20 30
         * / \
         * 40 50
         * /
         * 60
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
