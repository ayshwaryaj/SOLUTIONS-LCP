/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*class Solution {
    static int height(TreeNode root) {
        
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameterOfBinaryTree(root.left);
        int rdiameter = diameterOfBinaryTree(root.right);

        return Math.max(lheight + rheight, 
                        Math.max(ldiameter, rdiameter));
    }
}
   
 */   
class Solution {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        DOBT(root);
        return max;
     }
     private int DOBT(TreeNode root)
     {
        if (root == null)
            return 0;
        int L = DOBT(root.left);
        int R = DOBT(root.right);
        max = Math.max(max, L+R);
        return 1+Math.max(L,R);
     }
}


