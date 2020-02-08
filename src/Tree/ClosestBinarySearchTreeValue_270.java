package Tree;

/**
 * Created by yu7rin on 5/7/2018.
 */
public class ClosestBinarySearchTreeValue_270 {
    ///不要所有题目都想着要dfs或者bfs多想想树的性质，如何便利不一定只有d和b也可以有这道题的BST性质导航
    //或者像上117题一样先纵向再横向
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        while(root != null) {
            if(Math.abs(target - root.val) < Math.abs(target - result)) {
                result = root.val;
            }
            if(target > root.val) {
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return result;
    }
}
