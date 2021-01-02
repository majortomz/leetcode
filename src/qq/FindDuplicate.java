package qq;

import java.util.Arrays;

/**
 * Created by zjw on 2018/08/21 19:38
 * Description:
 */
public class FindDuplicate {

    public static int findnumber(int[] numbers) {
        int n = numbers.length;
        int target = -1;

        for(int i = 0; i < n; i++) {
            int num = numbers[i] % n;
            if(numbers[num] >= n) {
                target = num;
                break;
            }
            numbers[num] += n;
        }

//        System.out.println(Arrays.toString(numbers));

        for(int i = 0; i < n; i++) {
            numbers[i] %= n;
        }

        return target;
    }


    public static void main(String[] args) {
        System.out.println(findnumber(new int[]{2, 4, 1, 5, 7, 6, 1, 9, 0, 2}));
    }

}
