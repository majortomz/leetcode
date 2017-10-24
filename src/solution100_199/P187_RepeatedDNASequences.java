package solution100_199;

import java.util.*;

/**
 * Created by zjw on 2017/10/24.
 */
public class P187_RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() <= 10)   return res;

        char[] sc = s.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        int last = 0;

        for(int i = 0; i < sc.length; i++) {
            int code = 0;
            switch(sc[i]) {
                case 'A' : code = 0; break;
                case 'C' : code = 1; break;
                case 'G' : code = 2; break;
                case 'T' : code = 3; break;
            }
            last = (last << 2) & 0xFFFFF | code;
            if(i >= 9) {
                map.put(last, map.getOrDefault(last, 0) + 1);
                if(map.get(last) == 2) {
                    res.add(s.substring(i - 9, i + 1));
                }
            }
        }
        return res;
    }

}
