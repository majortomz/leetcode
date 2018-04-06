package solution800_899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zjw on 2018/04/01 9:32
 * Description:
 */
public class P811_SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> res = new ArrayList<>();
        if(cpdomains == null || cpdomains.length == 0)  return res;

        Map<String, Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains) {
            String[] cp = cpdomain.split(" ");
            Integer count = Integer.valueOf(cp[0]);
            String[] domains = cp[1].split("\\.");
            String b = domains[domains.length - 1];
            map.put(b, map.getOrDefault(b, 0) + count);
            for(int i = domains.length - 2; i >= 0; i--) {
                b = domains[i] + "." + b;
                map.put(b, map.getOrDefault(b, 0) + count);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }

        return res;
    }

}
