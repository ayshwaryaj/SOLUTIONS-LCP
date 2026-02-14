class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder)
    {
        Map<Integer, Integer> postMap = new HashMap<Integer, Integer>();
        for(int i = 0; i<postorder.length; i++)
            postMap.put(postorder[i],i);
        return buildTree(preorder, 0, preorder.length-1 , postorder, 0, postorder.length-1, postMap);
    }

    public TreeNode buildTree(int[] preorder, int prestart, int preEnd, int[] postorder, int poststart, int postEnd, Map<Integer, Integer> postMap)
    {
        if(poststart > postEnd || prestart>preEnd)
            return null;       
        TreeNode root = new TreeNode(preorder[prestart]);
        if (prestart == preEnd)
            return root;
   
        int Lroot = postMap.get(preorder[prestart + 1]);
        int numsL = Lroot - poststart + 1;
        root.left = buildTree(preorder, prestart+1, prestart+numsL, postorder, poststart, Lroot, postMap);
        root.right = buildTree(preorder, prestart+numsL+1, preEnd, postorder, Lroot+1, postEnd-1, postMap);
        
    return root;        
    }
}