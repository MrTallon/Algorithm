package queue;

import java.util.Scanner;

/**
 * Implement a Queue with Array
 *
 * @author YangBo
 * @date 2019/06/23
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组实现的队列");
        ArrayQueue queue = new ArrayQueue(3);

        // 接收用户输入
        char key;

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("------------");
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列的第一条数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

}

class ArrayQueue {
    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 该数组用于存放数据
     */
    private int[] arr;

    /**
     * 创建队列的构造方法
     *
     * @param arrMaxSize
     */
    ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        // 指向队列头部（指向队列头的前一个位置）
        front = -1;
        // 指向队列尾部（指向队列的最后一个数据）
        rear = -1;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    private boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    private boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列中（入队列）
     *
     * @param n
     */
    void addQueue(int n) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        // rear后移，赋值n
        arr[++rear] = n;
    }

    /**
     * 获取队列的数据（出队列）
     *
     * @return
     */
    int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列已空，不能取出数据");
        }
        // 取出front后一位的数据
        return arr[++front];
    }

    /**
     * 显出队列的所有数据
     */
    void showQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列头部数据（不取）
     *
     * @return
     */
    int headQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列已空，没有数据");
        }
        return arr[front + 1];
    }
}