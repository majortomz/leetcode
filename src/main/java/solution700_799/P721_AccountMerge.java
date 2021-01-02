package solution700_799;

import java.util.*;

/**
 * 18:58
 * Created by zjw on 2017/12/11 .
 */
public class P721_AccountMerge {

    // TLE
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<Set<String>> resultSet = new ArrayList<>();

        if(accounts == null)
            return new ArrayList<>();

        Map<String, List<Integer>> map = new HashMap<>();
        for(List<String> account : accounts) {
            String name = account.get(0);
            account.remove(0);

            if(!map.containsKey(name))  {
                map.put(name, new ArrayList<>());
            }
            Set<String> curSet = new HashSet<>();
            curSet.addAll(account);
            Iterator<Integer> iter = map.get(name).iterator();
            while(iter.hasNext()) {
                int pos = iter.next();
                Set<String> tmp = new HashSet<>();
                tmp.addAll(resultSet.get(pos));
                tmp.addAll(curSet);
                if(tmp.size() < resultSet.get(pos).size() + curSet.size()) {
                    curSet = tmp;
                    iter.remove();
                }
            }
            map.get(name).add(resultSet.size());
            resultSet.add(curSet);
        }

        List<List<String>> result = new ArrayList<>();
        for(String name : map.keySet()) {
            for(int pos : map.get(name)) {
                List<String> account = new ArrayList<>(resultSet.get(pos));
                account.sort((x, y) -> x.compareTo(y));
                account.add(0, name);
                result.add(account);
            }
        }
        return result;
    }

    // each account may has duplicate email, that is ["John", "john1@co", "john1@co"]
    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        if(accounts == null)
            return new ArrayList<>();

        List<List<String>> tmpAccounts = new ArrayList<>();
        Map<String, Integer> mailMap = new HashMap<>();     // email : pos
        Set<Integer> remains = new HashSet<>();             // record which pos remains
        String[] names = new String[accounts.size()];

        int pos = 0;

        for(List<String> account : accounts) {
            String name = account.get(0);
            names[pos] = name;
            account.remove(0);

            List<String> tmpAccount = new ArrayList<>();

            for(String mail : account) {
                if(mailMap.containsKey(mail)) {
                    int tmp = mailMap.get(mail);
                    if(tmp == pos)  continue;
                    remains.remove(tmp);
                    for(String tmpMail : tmpAccounts.get(tmp)) {
                        tmpAccount.add(tmpMail);
                        mailMap.put(tmpMail, pos);
                    }
                } else {
                    tmpAccount.add(mail);
                    mailMap.put(mail, pos);
                }
            }
            tmpAccounts.add(tmpAccount);
            remains.add(pos);
            pos++;
        }

        List<List<String>> result = new ArrayList<>();
        for(Integer index : remains) {
            List<String> list = tmpAccounts.get(index);
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            list.add(0, names[index]);
            result.add(list);
        }
        return result;
    }

    // Solution 3, from leetcode discussion
    public List<List<String>> accountsMerge3(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        // build graph
        for(List<String> account : accounts) {
            for(int i = 1; i < account.size(); i++) {
                if(!graph.containsKey(account.get(i)))
                    graph.put(account.get(i), new HashSet<>());
                graph.get(account.get(i)).add(account.get(1));
                graph.get(account.get(1)).add(account.get(i));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        // traverse each node
        for(List<String> account : accounts) {
            if(visited.add(account.get(1))) {
                List<String> list = new ArrayList<>();
                dfs(graph, account.get(1), visited, list);
                Collections.sort(list);
                list.add(0, account.get(0));
                result.add(list);
            }
        }
        return result;
    }

    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        visited.add(email);
        list.add(email);
        for(String s : graph.get(email)) {
            if(!visited.contains(s))
                dfs(graph, s, visited, list);
        }
    }


}
