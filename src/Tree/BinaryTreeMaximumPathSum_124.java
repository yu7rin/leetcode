package Tree;

/**
 * Created by yu7rin on 5/11/2018.
 */
public class BinaryTreeMaximumPathSum_124 {
    //次题目主要借鉴的是 Math.max(0 , helper(root.left));
    ///可以有效地去掉负数
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left =  Math.max(0 , helper(root.left));
        int right = Math.max(0 , helper(root.right));
        max = Math.max(max , left + right + root.val);
        return Math.max(left , right) + root.val;

    }
}
