package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/08 10:00
 * Description: 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        int[] map = new int[256];
        char[] arr = str.toCharArray();
        for(char c : arr) {
            map[c]++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(map[arr[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

}
