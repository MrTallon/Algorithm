package queue;

import java.util.Scanner;

/**
 * Implement a CircleQueue with Array
 *
 * @author YangBo
 * @date 2019/06/23
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组实现的环形队列");
        // 队列的最大有效数据量是3
        CircleArray queue = new CircleArray(4);

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

class CircleArray {
    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 队列头（队列的第一个元素）
     */
    private int front;

    /**
     * 队列尾(最后一个元素的后一个位置)
     */
    private int rear;

    /**
     * 该数组用于存放数据
     */
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列中
     *
     * @param n
     */
    public void addQueue(int n) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        // rear后移，使用取模，避免越界
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据
     *
     * @return
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列已空，不能取出数据");
        }
        // 将front对应的值保存进临时变量，同时将front后移(取模)
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显出队列的所有数据
     */
    public void showQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 当前队列的有效数据
     *
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列头部数据（不取）
     *
     * @return
     */
    public int headQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列已空，不能取出数据");
        }
        return arr[front];
    }

}
