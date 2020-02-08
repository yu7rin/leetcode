package Tree;

/**
 * Created by yu7rin on 4/30/2018.
 */
public class BinaryTreeRightSideView_199 {
    /////注意level和reult.size()的对应关系
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null) return result;
        helper(root , 0 , result);
        return result;

    }
    public void helper(TreeNode root , int level , List<Integer> result) {
        if (root == null) return;
        if (level == result.size()) {
            result.add(root.val);
        }
        helper(root.right , level + 1, result );
        helper(root.left , level + 1 , result);

    }
}
