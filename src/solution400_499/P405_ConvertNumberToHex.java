package solution400_499;

/**
 * Created by zjw on 2017/10/12.
 */
public class P405_ConvertNumberToHex {

    public String toHex(int num) {
        if(num == 0)    return "0";
        int temp = 0b1111;
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int a = num & temp;
            sb.insert(0, map[a]);
            num >>>= 4;
        }
        return sb.toString();
    }

}
