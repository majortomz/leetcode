package solution300_399;

import java.util.*;

/**
 * Created by zjw on 2018/01/26 14:29
 * Description:
 */
public class P399_EvaluateDivision {

    class Division {
        String divisor;
        double res;

        public Division(String divisor, double res) {
            this.divisor = divisor;
            this.res = res;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Division>> map = new HashMap<>();
        // init
        for(int i = 0; i < values.length; i++) {
            map.putIfAbsent(equations[i][0], new ArrayList<>());
            map.putIfAbsent(equations[i][1], new ArrayList<>());
            map.get(equations[i][0]).add(new Division(equations[i][1], values[i]));
            map.get(equations[i][1]).add(new Division(equations[i][0], 1 / values[i]));
        }

        double[] result = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            result[i] = -1.0;
            if(!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1])) {
                continue;
            }

            Queue<Division> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            boolean found = false;
            queue.add(new Division(queries[i][0], 1));
            while(!queue.isEmpty()) {
                Division cur = queue.poll();
                if(!visited.add(cur.divisor)) {
                    continue;
                }
                List<Division> list = map.get(cur.divisor);
                for(Division division : list) {
                    double div = cur.res * division.res;
                    if(division.divisor.equals(queries[i][1])) {
                        result[i] = div;
                        found = true;
                        break;
                    } else {
                        queue.add(new Division(division.divisor, div));
                    }
                }
                if(found) {
                    break;
                }
            }
        }
        return result;
    }

}
