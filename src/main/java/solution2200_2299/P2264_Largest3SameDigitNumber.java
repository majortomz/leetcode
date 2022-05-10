package solution2200_2299;

/**
 * Created by zjw on 2022/05/10 21:14
 * Description:
 */
public class P2264_Largest3SameDigitNumber {

    public String largestGoodInteger(String num) {
        char[] array =  num.toCharArray();
        int count = 1, resIndex = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                count++;
                if (count == 3 && (resIndex == -1 || array[i] > array[resIndex])) {
                    resIndex = i - 2;
                }
            } else {
                count = 1;
            }
        }
        return resIndex == -1 ? "" : num.substring(resIndex, resIndex + 3);
    }

}
