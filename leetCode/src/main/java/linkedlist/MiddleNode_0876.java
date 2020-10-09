package linkedlist;

/**
 * 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-03-23 12:19
 */
public class MiddleNode_0876 {
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (q !=null && q.next != null){
            q = q.next.next;
            p = p.next;
        }
        return p;
    }
}
