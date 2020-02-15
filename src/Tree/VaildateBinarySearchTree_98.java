package Tree; /**
 * Created by yu7rin on 4/26/2018.
 */
import java.util.*;
public class VaildateBinarySearchTree_98 {

    //使用indorder的错误解法 因为inorder的初始值还不够小 如果root == MIN_VALUE则无解
    long inorder = Math.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        System.out.print("&inorder = " + inorder + " root = " + root.val);
        if (isValidBST(root.left) && root.val > inorder) {
            inorder = root.val;
            System.out.println(": " + inorder);
        }
        else return false;
        return isValidBST(root.right);
    }





/////争取方法 大于最大的 小于最小的 大小两数值都要传输 分析树转折时的特征
// 不要想的很复杂 堪虑好返回true和false那个思路更清晰就些哪一个
    public boolean isValidBST(TreeNode root) {
        //System.out.println("ooori root = "+ root.val);
        return helper(root,null,null);
    }
    private boolean helper (TreeNode root , Integer max , Integer min) {
        if(root == null) return true;
        boolean left = helper(root.left , root.val , min);
        boolean right = helper(root.right , max, root.val);
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return left&&right;
    }
}