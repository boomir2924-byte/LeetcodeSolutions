class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inStart;

        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        int leftSize = rootIndex - inStart;

        root.left = build(preorder, preStart + 1,
                          preStart + leftSize,
                          inorder, inStart, rootIndex - 1);

        root.right = build(preorder, preStart + leftSize + 1,
                           preEnd,
                           inorder, rootIndex + 1, inEnd);

        return root;
    }
}