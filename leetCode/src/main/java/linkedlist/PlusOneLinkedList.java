package linkedlist;

/**
 * https://www.bilibili.com/video/av48277621/?p=4
 *
 * @author YangBo
 * @date 2019/04/15
 * <p>
 * 将链表中的数字加1
 * <p>
 * 提示：单向链表
 */
public class PlusOneLinkedList {

    //⬇️⬇️⬇️⬇️已知⬇️⬇️⬇️⬇️

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //⬆️⬆️⬆️⬆️已知⬆️⬆️⬆️⬆️

    private static ListNode plusOne(ListNode head) {
        //Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            i = j.next;
            if (j.val != 9) {
                i = j;
            }
        }

        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }
        if (dummy.val == 0) {
            return dummy.next;
        }
        return dummy;
    }
}
