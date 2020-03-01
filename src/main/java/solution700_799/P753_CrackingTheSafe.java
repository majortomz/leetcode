package solution700_799;

import java.util.*;

/**
 * Created by zjw on 2018/01/15 15:59
 * Description:
 */
public class P753_CrackingTheSafe {

    public String crackSafe(int n, int k) {
        StringBuilder result = new StringBuilder();
        Set<String> visited = new HashSet<>();
        int count = (int)Math.pow(k, n);

        for (int i = 1; i <= n; i++) {
            result.append("0");
        }
        visited.add(result.toString());
        dfs(result, visited, count, n, k);
        return result.toString();
    }

    private boolean dfs(StringBuilder result, Set<String> visited, int count, int n, int k) {
        if(visited.size() == count)  return true;
        String prefix = result.substring(result.length() - n + 1, result.length());
        for(int i = 0; i < k; i++) {
            String next = prefix + i;
            if(visited.contains(next))  continue;
            visited.add(next);
            result.append(i);
            if(dfs(result, visited, count, n, k))
                return true;
            result.delete(result.length() - 1, result.length());
            visited.remove(next);
        }
        return false;
    }


//    private String dfs2(Map<String, List<String>> map, Set<String> visited, String next, int count) {
//        if(count == 1) {
//            return next.substring(next.length() - 1, next.length());
//        }
//
//        for(String pwd: map.get(next)) {
//            if(visited.contains(pwd))  continue;
//            visited.add(pwd);
//            String suffix = dfs(map, visited, pwd.substring(1, pwd.length()), count - 1);
//            if(suffix.length() == count - 1) {
//               return next + suffix;
//            }
//            visited.remove(pwd);
//        }
//        return "";
//    }

}
