package solution400_499;

/**
 * Created by zjw on 2018/01/27 15:50
 * Description:
 */
public class P415_AddStrings {

    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray(), arr2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i >= 0 ? arr1[i] - '0' : 0;
            int b = j >= 0 ? arr2[j] - '0' : 0;
            int sum = a + b + c;
            sb.append(sum % 10);
            c = sum / 10;
        }
        if(c > 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }

}
