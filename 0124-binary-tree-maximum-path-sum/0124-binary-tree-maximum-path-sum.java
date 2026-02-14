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
class Solution {
    int m= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        DOBT(root);
        return m;
    }
    private int DOBT(TreeNode root)
    {
        if(root == null)
            return 0;
        int L=Math.max(0,DOBT(root.left));
        int R=Math.max(0,DOBT(root.right));
        m = Math.max(m, L+R+root.val);
        return root.val+Math.max(L,R);
    
    }
}