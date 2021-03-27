import java.util.Stack;

public class PreOrderTraversal {

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

      public void recursivePreOrderTraversal(TreeNode root) {
           if(root == null) {
               return;
           }
           System.out.print(root.data + " ");
           recursivePreOrderTraversal(root.left);
           recursivePreOrderTraversal(root.right);

      }


      public void iterativePreOrderTraversal() {

          if(root == null) {
              return;
          }

          Stack<TreeNode> stack = new Stack<>();
          stack.push(root);

          while (!stack.isEmpty()) {
              TreeNode temp = stack.pop();
              System.out.print(temp.data + " ");

              if(temp.right != null) {
                  stack.push(temp.right);
              }

              if(temp.left != null) {
                  stack.push(temp.left);
              }
          }

      }


      public static void main(String[] args) {

           PreOrderTraversal preOrderTraversal = new PreOrderTraversal();

           preOrderTraversal.createBinaryTree();
           System.out.print("recursivePreOrder : ");
           preOrderTraversal.recursivePreOrderTraversal(preOrderTraversal.root);
           System.out.println();
           System.out.print("iterativePreOrder : ");
           preOrderTraversal.iterativePreOrderTraversal();

      }

}



