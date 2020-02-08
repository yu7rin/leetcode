package Tree;

/**
 * Created by yu7rin on 5/11/2018.
 */
public class RecoverBinarySearchTree_99 {
    ////BST异常分析重要部分！！！！！谨记 多画图
    ///注意分析BST异常通常是Pre.val > post.val但是记录TreeNode时要考虑
    ///两异常值相邻的情况 不要出现Pre.val > post.val只记录前面的pre！！！！
    TreeNode node1 = null;
    TreeNode node2 = null;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        dfs(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }


    public void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        if(pre != null && root.val <= pre.val){
            if(node1 == null) node1 = pre;
            node2 = root;
        }
        pre = root;
        dfs(root.right);
    }
}
