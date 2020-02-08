package Tree;

/**
 * Created by yu7rin on 5/6/2018.
 */
public class PopulatingNextRightPointersinEachNodeII_117 {
    //////如果可以写嵌套if就不要罗列很多if
    //////注意pre指针的移动方式
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while(cur != null) {

            TreeLinkNode pre = null;
            TreeLinkNode head = null;
            while(cur != null){
                if(cur.left != null) {
                    if(pre != null) {
                        pre.next = cur.left;;
                    } else {
                        head = cur.left;

                    }   pre = cur.left;
                }
                if(cur.right != null) {
                    if(pre != null) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;

                    } pre = cur.right;
                }
                cur = cur.next;

            }
            cur = head;

        }
    }
}
