class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length; i++)
            inMap.put(inorder[i], i);
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }
    private TreeNode buildTree(int[] preorder, int prestart, int preEnd, int[] inorder, int instart, int inEnd, Map<Integer, Integer> inMap)
    {
        if(instart > inEnd || prestart > preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        if(prestart == preEnd)
            return root;
        int inRoot = inMap.get(root.val);
        int numsL =inRoot - instart;
        root.left = buildTree(preorder, prestart+1, prestart+numsL, inorder, instart, inRoot-1, inMap);
        root.right = buildTree(preorder, prestart+numsL+1, preEnd, inorder, inRoot+1, inEnd, inMap);
        return root;
    }
}