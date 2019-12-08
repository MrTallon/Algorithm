
![可遇不可求](https://pic1.zhimg.com/v2-4f35229fc9f78cd6fe074cab84bc20ff_r.jpg)

## 数据结构

### 线性结构

-  数据元素之间存在一对一的线性关系
-  顺序存储结构和链式存储结构
    - 顺序存储的线性表称为顺序表，顺序表表中的元素是连续的
    - 链式存储的线性表称为链表，链表中的元素不一定是连续的，元素节点中存放数据元素以及相邻元素的节点信息
-  常见的线性结构有：数组，队列，链表和栈。

### 非线性结构

- 常见的非线性结构有：二维数组，多维数组，广义表，树结构，图结构 

---

## 稀疏数组和队列

### 稀疏数组

当一个数组中大部分元素是0或者为同一个值的数组中，可以用稀疏数组保存该数组

**处理方法**
1. 记录数组中一共有几行几列，有多少个不同的值
2. 把具有不同值元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模

![稀疏数组](https://github.com/MrTallon/Mind-Palace/blob/master/img/%E7%A8%80%E7%96%8F%E6%95%B0%E7%BB%84.jpg?raw=true)

### 稀疏数组的压缩和解压

[棋盘案例](https://github.com/MrTallon/Algorithm/blob/master/dataStructure/src/sparsearray/SparseArray.java)

### 队列

- 队列是一个有序列表，可以用数组或链表实现
- 遵循**先入先出**原则

用一个环形的数组实现队列，达到复用效果（取模）

[普通数组](https://github.com/MrTallon/Algorithm/blob/master/dataStructure/src/queue/ArrayQueueDemo.java)

普通数组-》环形数组

思路：
1. front 指向队列的第一个元素，arr[front]就是队列的第一个元素，front 初始值为0
2. rear 指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定，初始值为0
3. 当 (rear+1)%maxSize = front 时，队列满
4. 当 rear == front 时，队列空
5. 队列中有效数据个数：(rear+maxSize-front)%maxSize

[环形数组](https://github.com/MrTallon/Algorithm/blob/master/dataStructure/src/queue/CircleArrayQueueDemo.java)

## 链表

## 栈

## 队列

## 排序算法（8）

## 查找算法

## 哈希表

## 树

### 二叉树

### 实际应用

#### 堆排序

#### 赫夫曼树

## 图

### 深度优先搜索