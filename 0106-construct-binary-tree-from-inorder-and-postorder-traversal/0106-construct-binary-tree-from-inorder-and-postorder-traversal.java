class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1,
                     0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int inStart, int inEnd,
                           int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int index = inStart;
        while (inorder[index] != rootValue) {
            index++;
        }

        int leftSize = index - inStart;

        root.left = build(inorder, postorder,
                          inStart, index - 1,
                          postStart, postStart + leftSize - 1);

        root.right = build(inorder, postorder,
                           index + 1, inEnd,
                           postStart + leftSize, postEnd - 1);

        return root;
    }
}