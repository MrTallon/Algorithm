package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表中的环
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-10-09 10:58
 */
public class HasCycle_0141 {
    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 遍历，哈希
     */
    public boolean hashSet(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
