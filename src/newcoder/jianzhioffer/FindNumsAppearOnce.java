package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 11:25
 * Description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 */
public class FindNumsAppearOnce {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int a = 0;
        for(int num : array) {
            a ^= num;
        }
        num1[0] = num2[0] = a;
        int flag = 1;
        while((flag & a) == 0)    flag <<= 1;
        for(int num : array) {
            if((flag & num) == 0)   num1[0] ^= num;
            else num2[0] ^= num;
        }
    }
}
