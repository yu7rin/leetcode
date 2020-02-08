package LinkedList;

/**
 * Created by yu7rin on 6/8/2018.
 */
public class ReverseLinkedlistII_92 {
    ///第一种解法 原始的整体反转法
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode post = head;
        while(m > 1) {
            pre = pre.next;
            head = head.next;
            m--;
            n--;
        }
        ListNode node = pre;
        ListNode a = head.next;
        while(n > 0) {
            ListNode temp = head.next;
            head.next = node;
            node = head;

            head = temp;
            n--;
        }
        pre.next.next = head;
        pre.next = node;
        return dummy.next;
    }
    ///第二中方法 不反转整个n-m链表 只是把每一个n后面的m之前的node都放在n前面去
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        while(m > 1) {
            pre = pre.next;
            head = head.next;
            m--;
            n--;
        }
        while(n > 1) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = pre.next;
            pre.next = temp;
            n--;
        }
        return dummy.next;
    }
}
