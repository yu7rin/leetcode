package LinkedList;

/**
 * Created by yu7rin on 6/7/2018.
 */
public class RemoveDuplicatesfromSortedListII_82 {
    ////！！！！！！！重写needed
    ////注意，由于本题目要求完全删除重复的元素，所以当发现新的重复元素时，
    // head指针指到后值不相等的node后直接赋值给dummy。next，随后不需要进入next位置
    //因此于未找到相同值时的dummy和head指针同时向后进位不同
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode result = dummy;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;
                dummy.next = head;
            } else {
                dummy.next = head;
                dummy = dummy.next;
                head = head.next;
            }
        }
        return result.next;
    }
    /////方法二，用单一node以及node.next和。node.next.next代表后两点
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode result = dummy;
        while(dummy.next != null && dummy.next.next != null) {
            if(dummy.next.val == dummy.next.next.val) {
                int val = dummy.next.val;
                while(dummy.next != null && dummy.next.val == val) {
                    dummy.next = dummy.next.next;
                }
            } else {
                dummy = dummy.next;
            }
        }
        return result.next;
    }
}
