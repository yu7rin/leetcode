package Tree;

/**
 * Created by yu7rin on 5/7/2018.
 */
public class FlattenBinaryTreetoLinkedList_114 {
    ////多画图 多观察 仔细看题目意思 这道题就是简单的左边放在右边上面，
    // 注意右边需要每次循环到最底端在进行右边的链接
    // 注意思路
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.right == null) {
            root.right = root.left;
            root.left = null;
        } else {
            if(root.left != null) {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = null;
                while(root.right != null) {
                    root = root.right;
                }
                root.right = temp;
            }
        }

    }
}
