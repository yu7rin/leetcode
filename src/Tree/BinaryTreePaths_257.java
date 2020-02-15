package Tree;

/**
 * Created by yu7rin on 4/26/2018.
 */

/////可直接利用String的不可modify性质 直接传入String进入下一递归 从而不用新建容器
public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        if(root == null) return result;
        helper(root, "" + root.val, result);
        return result;

    }
    public void helper (TreeNode root , String s, List<String> result) {
        if(root.left == null && root.right == null) {
            result.add(s + root.val);
        }
        if(root.right != null) helper(root.right , s + root.val + "->" ,result);
        if(root.left != null) helper(root.left , s + root.val + "->"  , result);
    }
}
