package Tree;

/**
 * Created by yu7rin on 5/6/2018.
 */
public class PopulatingNextRightPointersinEachNode_116 {
    //次题目需要先序遍历，先链所有啊可以连接的 否则较深处两子数之间的next无法连接
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);


    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;
        while (node != null) {
            TreeLinkNode cur = node;
            while (cur != null) {
                if(cur.left != null) cur.left.next = cur.right;
                if(cur.left != null && cur.next != null) {
                    ////注意考虑cur有没有下一层
                    // /每次调用下一层都要记住预防null
                    cur.right.next = cur.next.left;

                }
                cur = cur.next;

            }
            node = node.left;
        }
    }
}
