package Tree;

import javax.swing.tree.TreeNode;

/**
 * Created by yu7rin on 4/25/2018.
 */

///适用于BST的跨苏LCA解法
public class LowestCommonAncestorOfBinarySearchTree_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode q, TreeNode p) {
        //不需要添加null时的判断 适用bst可以准确的通过路径找到q和p。
        if (q.val < root.val && p.val < root.val) {
            return lowestCommonAncestor(root.left, q, p);
        }
        if (q.val > root.val && p.val > root.val) {
            return lowestCommonAncestor(root.right, q, p);
        }
        //非一同大于root.val 非一同小于说明root或是左右lca，或者root.val等于q，p其中的一个val 则为自我型lca
        return root;
    }
    //透过普通Bianry Tree的改良LCA算法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root;
        TreeNode left = null;
        TreeNode right = null;
        if (p.val < root.val || q.val < root.val) {
            left = lowestCommonAncestor(root.left ,p ,q);
        }
        if (p.val > root.val || q.val > root.val) {
            right = lowestCommonAncestor(root.right , q, p);
        }
        if(left != null && right != null) return root;
        if(left == null && right != null) return right;
        if(left != null && right == null) return left;

        return null;
    }
}
