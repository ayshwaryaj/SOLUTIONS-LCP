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
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> a = new ArrayList();
        PsOT(root, a);
        return a; 
    }
    private void PsOT(TreeNode root, List<Integer> a)
    {
        if(root == null)
            return;
        PsOT(root.left, a);
        PsOT(root.right, a);
        a.add(root.val);
    }

}