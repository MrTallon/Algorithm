package linkedlist;

/**
 * 寻找环的起始节点
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-05 09:50
 */
public class Test {
    private ListNode findNode(ListNode head) {
        ListNode fast = null, slow;
        while (head.next != null && head.next.next != null) {
            fast = head.next.next;
            slow = head.next;
            if (fast == slow) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
