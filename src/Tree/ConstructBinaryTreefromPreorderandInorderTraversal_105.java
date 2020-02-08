package Tree;

/**
 * Created by yu7rin on 5/9/2018.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
/////通过两种不同的traverl确定具体每个节点的位置，多画图分析即可得出结论
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0 , inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inStart;
        while(inRoot <= inEnd) {
            if(inorder[inRoot] == preorder[preStart]) break;
            inRoot++;
        }
        root.left = helper(preorder, inorder, preStart + 1, preStart + inRoot - inStart, inStart , inRoot - 1);
        root.right = helper(preorder, inorder, preStart + inRoot - inStart + 1, preEnd, inRoot + 1 , inEnd);
        return root;
    }

}
