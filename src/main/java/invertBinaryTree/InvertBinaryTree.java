package invertBinaryTree;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeRec(root);
        return root;
    }

    public void invertTreeRec(TreeNode root) {
        // Base case
        if(root == null)
            return;

        // Recursively invert left and right subtrees
        invertTreeRec(root.left);
        invertTreeRec(root.right);

        // Swap left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
