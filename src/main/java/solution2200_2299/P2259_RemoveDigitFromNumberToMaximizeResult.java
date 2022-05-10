package solution2200_2299;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by zjw on 2022/05/04 17:36
 * Description:
 */
public class P2259_RemoveDigitFromNumberToMaximizeResult {

    public String removeDigit(String number, char digit) {
        String prefix = "", resPrefix = "";
        for (char c : number.toCharArray()) {
            if (c == digit && (resPrefix.equals("") || prefix.compareTo(resPrefix) >= 0)) {
                resPrefix = prefix;
            } else {
                resPrefix += c;
            }
            prefix += c;
        }
        return resPrefix;
    }

}
