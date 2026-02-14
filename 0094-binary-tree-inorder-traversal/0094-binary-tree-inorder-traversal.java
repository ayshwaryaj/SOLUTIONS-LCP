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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> a = new ArrayList();
        IOT(root, a);
        return a;
    }
    private void IOT(TreeNode root, List<Integer> a)
    {
        if(root == null)
            return;
        IOT(root.left, a);
        a.add(root.val);
        IOT(root.right,a);
    }
}

