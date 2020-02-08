package LinkedList;

/**
 * Created by yu7rin on 6/9/2018.
 */
public class InsertionSortList_147 {
    ///常规解法 对比后换位 注意定义node清晰准却 判定while语句条件是画图计算
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next != null) {
            if(head.next.val >= head.val) {
                head = head.next;
            } else {
                ListNode temp = dummy;
                ListNode node = head.next;
                head.next = head.next.next;
                while(temp != head) {
                    if(node.val > temp.next.val) {
                        temp = temp.next;
                    } else {
                        node.next = temp.next;
                        temp.next = node;
                        break;
                    }
                }
            }
        } return dummy.next;
    }

    ///版本2 小幅度修改了第二个while的条件 更加精简一点 没有本质区别
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next != null) {
            if(head.next.val >= head.val) {
                head = head.next;
            } else {
                ListNode temp = dummy;
                ListNode node = head.next;
                head.next = head.next.next;
                while(node.val > temp.next.val) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
            }
        }return dummy.next;
    }
}
