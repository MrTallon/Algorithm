package queue;

/**
 * Implement a queue
 * queue 需要两个指针
 *
 * @author YangBo
 * @date 2019/04/28
 */
public class Queue {

    private static class Node {
        private int val;
        private Node next;

        private Node(int x) {
            this.val = x;
        }
    }

    private Node head;
    private Node tail;

    public int peak() {
        return head.val;
    }

    public void add(int val) {
        Node node = new Node(val);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    public int remove() {
        int value = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }
}
