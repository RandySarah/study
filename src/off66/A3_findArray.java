package off66;

/**
 * Q3:在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 二维数组如下所示：
 * 1 2 8  9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 *
 * A3:
 * 1、数组右上角的数字等于该数字则查找结束
 * 2、若该数字大于要查找的数字，则剔除该数字所在的列；若该数组小于要查找的数字，则剔除该数字所在的行
 * 3、查找的范围：直到查找出该数字，或者查找范围为空
 */
public class A3_findArray {

    /**
     * @param array 待查找的数组
     * @param num 要查找的数据
     * @return 查找结果
     */
    public static boolean find(int[][] array, int num){

        //1、数组无效，返回false
        if(array == null || array.length < 1 || array[0].length <1){
            return false;
        }

        int row = array.length; //数组行数
        int col = array[1].length; //数组列数

        int r = 0; //查找起始的行号
        int c = col - 1; //查找起始的列号

        //2、查找--要查找的位置确保在数组之内 查找区间在[0,row),[0,col)
        while (r >= 0 && r < row && c >= 0 && c < col){
            if(array[r][c] == num){
                return true;
            }else if(array[r][c] > num){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 7));
        System.out.println(find(matrix, 5));
        System.out.println(find(matrix, 1));
    }

}
