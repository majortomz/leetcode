package solution800_899;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/04/16 10:14
 * Description:
 */
public class P816_AmbiguousCoordinates {

    public List<String> ambiguousCoordinates(String S) {
        List<String> list = new ArrayList<>();
        for(int i = S.length() - 3; i >= 1; i--) {
            String sx = S.substring(1, i + 1), sy = S.substring(i + 1, S.length() - 1);
            List<String> lx = getAllDigits(sx), ly = getAllDigits(sy);
            if(lx.size() > 0 && ly.size() > 0) {
                for(String x : lx) {
                    for(String y : ly) {
                        list.add("(" + x + ", " + y + ")");
                    }
                }
            }
        }
        return list;
    }

    private List<String> getAllDigits(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() == 1) {
            list.add(s);
        } else if(s.charAt(0) == '0') {
            // 以 0 开头
            if(s.charAt(s.length() - 1) != '0') {
                list.add("0." + s.substring(1, s.length()));
            }
        } else {
            // 非 0 开头
            if(s.charAt(s.length() - 1) != '0') {
                int bound = s.length() - 2;
                for(int i = 0; i <= bound; i++) {
                    list.add(s.substring(0, i + 1) + '.' + s.substring(i + 1, s.length()));
                }
            }
            list.add(s);
        }
        return list;
    }

}
