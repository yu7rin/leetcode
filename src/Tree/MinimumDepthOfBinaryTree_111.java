package Tree;

/**
 * Created by yu7rin on 4/25/2018.
 */
public class MinimumDepthOfBinaryTree_111 {

    ///注意返回值的四种可能性(单左，单右，左右空，左右不空)的处理；
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 && right == 0) {
            return 1;
        } else if (left == 0) {
            return right + 1;
        } else if (right == 0){
            return left + 1;
        } else {
            return Math.min(right , left) + 1;
        }
    }
}
