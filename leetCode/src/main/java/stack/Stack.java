package stack;

/**
 * Implement a stack
 * stack 一个指针
 *
 * @author YangBo
 * @date 2019/04/28
 */
public class Stack {

    private static class Node{
        private int val;
        private Node next;

        private Node(int x) {
            this.val = x;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peak() {
        //check empty
        return top.val;
    }

    public void push(int value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
    }

    public int pop() {
        int value = top.val;
        top = top.next;
        return value;
    }

}
