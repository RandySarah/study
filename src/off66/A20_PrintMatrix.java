package off66;

/**
 * Q20.顺时针打印矩阵
 *
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 *
 * 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 *
 * A:把矩阵看做由若干个顺时针方向的圈组成，矩阵循环打印下去的条件为5(行数和列数)>2*2(中间一个数字的下标为2*2)
 * 打印一圈的功能共分为四步，从左到右打印为第一步，从上到下打印为第二步，从右到左打印为第三步，从上到下为第四步
 * 但最后一圈有可能退化成只有一行或者一列，不需要四步都走完
 *
 * 第一步总是需要
 * 第二步的条件：终止行号大于起始行号
 * 第三步的条件为：圈内至少有两行两列
 * 第四步的条件是：圈内至少有三行两列
 * */
public class A20_PrintMatrix {

    public static void printMatrix(int[][] numbers){

        if (numbers == null) {
            return;
        }
        // 记录一圈（环）的开始位置的行
        int x = 0;
        // 记录一圈（环）的开始位置的列
        int y = 0;
        // 对每一圈（环）进行处理，
        // 行号最大是(numbers.length-1)/2
        // 列号最大是(numbers[0].length-1)/2
        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printCircle(numbers, x, y);
            // 指向下一个要处理的的环的第一个位置
            x++;
            y++;
        }

    }

    public static void printCircle(int[][] numbers, int x, int y){
        int rows = numbers.length; //数组的行数
        int cols = numbers[0].length; //数组的列数

        // 输出环的上面一行，包括最中的那个数字
        for (int i = y; i <= cols - y - 1; i++) {
            System.out.print(numbers[x][i] + " ");
        }

        // 环的高度至少为2才会输出右边的一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (rows - x - 1 > x) {
            // 因为右边那一列的最上面那一个已经被输出了，所以行呈从x+1开始，
            // 输出包括右边那列的最下面那个
            for (int i = x + 1; i <= rows - x - 1; i++) {
                System.out.print(numbers[i][cols - y - 1] + " ");
            }
        }

        // 环的高度至少是2并且环的宽度至少是2才会输出下面那一行
        // cols-1-y：表示的是环最右那一列的列号
        if (rows - x - 1 > x && cols - 1 - y > y) {
            // 因为环的左下角的位置已经输出了，所以列号从cols-y-2开始
            for (int i = cols - y - 2; i >= y; i--) {
                System.out.print(numbers[rows - 1 - x][i] + " ");
            }
        }

        // 环的宽度至少是2并且环的高度至少是3才会输出最左边那一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            // 因为最左边那一列的第一个和最后一个已经被输出了
            for (int i = rows - 1 - x - 1; i >= x + 1; i--) {
                System.out.print(numbers[i][y] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        printMatrix(numbers);
        System.out.println();
    }
}
