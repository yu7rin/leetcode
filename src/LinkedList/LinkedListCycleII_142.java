package LinkedList;

/**
 * Created by yu7rin on 6/15/2018.
 */
public class LinkedListCycleII_142 {
    /////很好的解法 原理是 2（a+b）= a+ b+ c + b 所以 b = c

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ///提前走一步就可以避免起始点相同的问题 非常简单有效
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
               /////不需要单家if 直接写在while循环的条件里 非常方便
                while(head != fast) {
                    head = head.next;
                    fast = fast.next;

                }return fast;
            }

        }
        return null;

    }
}