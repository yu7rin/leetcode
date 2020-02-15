package Tree;

/**
 * Created by yu7rin on 4/28/2018.
 */
public class CountUnivalueSubTrees_250 {
    ///常规解法 没什么特别要注意的 写if判断条件时如果正向condition比较复杂那么就写反向的 一般会比较简短方便看下面例子
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        count = 0;
        helper(root);
        return count;

    }
    public boolean helper(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if(left && right) {
            if(root.left != null && root.left.val != root.val) return false;
            if(root.right != null && root.right.val != root.val) return false;
            count++;
            return true;
        }
        //例如这两段if的对比 非常的明显
//        if( left && right) {
//            if(root.left == null && root.right.val == root.val) {
//                count++;
//                return true;
//            } else if(root.right == null && root.left.val == root.val) {
//                count++;
//                return true;
//            } else if (root.left != null && root.right != null && root.right.val == root.val && root.left.val == root.val) {
//                count++;
//                return true;
//            }
        return false;
    }
}
