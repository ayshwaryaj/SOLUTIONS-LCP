/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public int maxDepth(TreeNode root) {
    if (root == null) return 0; // Base case
    int left = maxDepth(root.left);  // DFS Left
    int right = maxDepth(root.right); // DFS Right
    return Math.max(left, right) + 1; // Process node
}

}
