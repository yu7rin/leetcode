package LinkedList;

/**
 * Created by yu7rin on 6/14/2018.
 */
public class RotateList_61 {
    ////找到环形后再切开可有效防止错误的head.next = null的赋值
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            head = head.next;
            length++;
        }
        head.next = dummy.next;
        int offset = k % length;
        for (int i = 0; i < length - offset; i++) {
            dummy = dummy.next;
        }
        ListNode result = dummy.next;
        dummy.next = null;

        return result;

    }
}
