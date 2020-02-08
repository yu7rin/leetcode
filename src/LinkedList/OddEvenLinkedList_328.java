package LinkedList;

/**
 * Created by yu7rin on 6/10/2018.
 */
public class OddEvenLinkedList_328 {
    /////复杂的解法 由于对space（1）的条件有理解偏差所以定义上有所复杂，并不需要靠计数决定积数偶数
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        int pos = 2;
        ListNode result = head;
        ListNode even = head.next;
        ListNode odd = head;
        ListNode pre = head;
        head = head.next;
        while(head != null) {
            if(pos % 2 != 0) {
                odd.next = head;
                pre.next = head.next;
                odd = odd.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
            pos++;
        }
        odd.next = even;
        return result;
    }
    ////版本二 并不需要复杂的指针 只需要新建even odd 和evenHead即可完成整个编程
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;

        }
        odd.next = evenHead;
        return head;
    }
}
