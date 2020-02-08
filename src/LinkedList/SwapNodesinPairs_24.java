package LinkedList;

/**
 * Created by yu7rin on 6/6/2018.
 */
public class SwapNodesinPairs_24 {
    ///第一种方法。三个ListNode分别是前中后 有点复杂
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode post = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = head.next;
        while(post != null) {
            pre.next = post.next;
            post.next = pre;
            dummy.next = post;
            dummy = pre;
            pre = pre.next;
            if(pre != null) {
                post = post.next.next.next;
            } else {
                break;
            }
        }return head;
    }
    ///第二种方法可以用双指针利用中指针替代中后两个指针，同时判断是否可以继续循环的方式也简单些，不用在多加if语句了
    public ListNode swapPairs(ListNode head) {
        //
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head.next;
        ListNode pre = dummy;
        ListNode post = head;
        while(post != null && post.next != null) {
            ListNode temp = post.next.next;
            post.next.next = post;
            pre.next = post.next;
            post.next = temp;
            pre = post;
            post = temp;
        }
        return dummy.next;
    }
}
