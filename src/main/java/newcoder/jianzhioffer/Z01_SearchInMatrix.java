package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/01 15:31
 * Description: 二维数组中的查找
 */
public class Z01_SearchInMatrix {

    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0)    return false;

        int height = array.length, width = array.length;
        int i = 0, j = width - 1;
        while(i < height && j >= 0) {
            if(array[i][j] > target)    j--;
            else if(array[i][j] < target) i++;
            else return true;
        }
        return false;
    }
}
