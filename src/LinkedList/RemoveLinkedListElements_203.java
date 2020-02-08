package LinkedList;

/**
 * Created by yu7rin on 6/10/2018.
 */
public class RemoveLinkedListElements_203 {
    ////虽然是很简单的题目但是一定要堪虑清楚head进位的条件 非常重要 人工运行代码并且画图分析
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head != null && head.next != null) {
            if(head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
