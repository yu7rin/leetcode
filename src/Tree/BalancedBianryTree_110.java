package Tree;

/**
 * Created by yu7rin on 4/30/2018.
 */
public class BalancedBianryTree_110 {
    //注意利用题目中没有的值来返回不同的状态
    //本题中使用负数值 -1 来反馈false g'v'f'g
    public boolean isBalanced (TreeNode root) {
        return deep(root) == -1 ? false : true;
    }
    public int deep (TreeNode root) {
        if(root == null) return 0;
        int left = deep(root.left);
        int right = deep(root.right);
        if(left == -1 || right ==-1 || Math.abs(right - left) > 1) return -1;
        return Math.max(left , right) + 1;
    }

}
