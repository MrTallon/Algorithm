package linkedlist;

/**
 * 链表交换
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-08-17 10:08
 */
public class SwapPairs_0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
