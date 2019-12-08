package sparsearray;

/**
 * Implement a sparseArray
 * <p>
 * 以 11*11 的棋盘为例，0表示没有棋子，1表示白子，2表示黑子
 *
 * @author YangBo
 * @date 2019/06/23
 */
public class SparseArray {
    public static void main(String[] args) {
        System.out.println("---原始的二维数组---");
        for (int[] row : chessArray()) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("\t\n---原始数组 -》稀疏数组---");
        int[][] ints = sparseArray(chessArray());
        for (int i = 0; i < sparseArray(chessArray()).length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", ints[i][0], ints[i][1], ints[i][2]);
        }

        System.out.println("\t\n---稀疏数组 -》原始数组---");
        for (int[] row : converArray(sparseArray(chessArray()))) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /**
     * 原始数组
     * 假设棋盘上黑子白子各有一个
     *
     * @return
     */
    private static int[][] chessArray() {
        int[][] chessArr = new int[11][11];
        // 第二行第三列一颗白子
        chessArr[1][2] = 1;
        // 第三行第四列一颗黑子
        chessArr[2][3] = 2;
        return chessArr;
    }

    /**
     * 将原始二维数组转化为稀疏数组
     *
     * @param chessArray
     * @return
     */
    private static int[][] sparseArray(int[][] chessArray) {
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = chessArray.length;
        sparseArr[0][1] = chessArray[0].length;
        sparseArr[0][2] = sum;
        // 遍历二维数组，将非0数据放入稀疏数组
        // 用于记录第几个非0数据
        int count = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray[i][j];
                }
            }
        }
        return sparseArr;
    }

    /**
     * 将稀疏数组转化为原始的二维数组
     *
     * @param sparseArray
     * @return
     */
    private static int[][] converArray(int[][] sparseArray) {

        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int[][] array = new int[row][col];
        for (int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }
}
