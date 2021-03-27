import java.util.Stack;

public class InOrderTraversal {

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

    public void recursiveInOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        recursiveInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        recursiveInOrderTraversal(root.right);
    }

    public void iterativeInOrderTraversal() {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {

            if(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }

    }

    public static void main(String[] args) {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        inOrderTraversal.createBinaryTree();
        System.out.print("recursiveInOrder : ");
        inOrderTraversal.recursiveInOrderTraversal(inOrderTraversal.root);
        System.out.println();
        System.out.print("iterativeInOrder : ");
        inOrderTraversal.iterativeInOrderTraversal();

    }


}
