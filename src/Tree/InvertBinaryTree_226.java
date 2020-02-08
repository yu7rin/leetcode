package Tree;

/**
 * Created by yu7rin on 4/29/2018.
 */
public class InvertBinaryTree_226 {
    /////不要想成sametree那种双pointer的，注意树和链表一样，上一个节点控制整棵树的形状，
    // 修改root.left，root.right的取值而不是简单的left,right
    // 注意以后向子函数传值时考虑是否有可能空指针或者越界
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        helper(root);
        return root;
    }
    private void helper(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }
}
