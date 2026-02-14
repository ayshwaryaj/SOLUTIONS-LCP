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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        while(q.isEmpty() == false)
        {
            int size = q.size();
            List<Integer> sub = new LinkedList<>();
            for(int i = 0; i<size; i++)
            {
                TreeNode LFE = q.poll();
                sub.add(LFE.val);
                if(LFE.left !=null)
                    q.add(LFE.left);
                if(LFE.right !=null)
                    q.add(LFE.right);
            }
            res.add(sub);
        }
        return res;
    }
}