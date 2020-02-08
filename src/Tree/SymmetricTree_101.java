package Tree;

/**
 * Created by yu7rin on 4/29/2018.
 */
public class SymmetricTree_101 {
    ///不要被思维定式圈住 多画图 多分析
    public boolean isSymmetric(TreeNode root) {
        if( root == null) return true;
        return subSymmetric(root.left , root.right);
    }
    public boolean subSymmetric(TreeNode lRoot,TreeNode rRoot){
        if(lRoot == null && rRoot == null ) return true;
        else if(lRoot == null || rRoot == null) return false;
        else if(lRoot.val != rRoot.val) return false;
        return subSymmetric(lRoot.left,rRoot.right) && subSymmetric(rRoot.left,lRoot.right);
    }
}
