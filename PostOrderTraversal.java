import java.util.Stack;

public class PostOrderTraversal {

    private TreeNode root;

    static class TreeNode {
        private final int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        /*
                  1
               /    \
              2       3
            /   \    /  \
           4     5  6    7

         */

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        third.left = six;
        third.right = seven;

    }

    public void recursivePostOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        recursivePostOrderTraversal(root.left);
        recursivePostOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public void iterativePostOrderTraversal() {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                TreeNode temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }else {
                    current = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        postOrderTraversal.createBinaryTree();

        System.out.print("recursivePostOrder : ");
        postOrderTraversal.recursivePostOrderTraversal(postOrderTraversal.root);
        System.out.println();
        System.out.print("iterativePostOrder : ");
        postOrderTraversal.iterativePostOrderTraversal();

    }


}
