class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null)
            return false;
        switch(root.val)
        {
            case 2:
                return evaluateTree(root.left) || evaluateTree(root.right); 
            case 3:
                return evaluateTree(root.left) && evaluateTree(root.right); 
            default:
            {
                boolean b = (root.val != 0);
                return b;
            }
        }
    }
}
