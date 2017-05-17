package solution500_599;

import java.util.*;

/**
 * Created by zjw on 2017/5/17.
 */
public class P582_KillProcess {

    // TLE
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
         List<Integer> res = new ArrayList<>();
         res.add(kill);
         int i = 0;
         while(i < res.size())
         {
             int ele = res.get(i);
             for(int k=0; k<ppid.size(); k++)
             {
                 if(ppid.get(k) == ele)
                     res.add(pid.get(k));
             }
             i++;
         }
         return res;
    }

    public List<Integer> killProcess2(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        res.add(kill);
        // save the position
        int maxPos = 0;
        for(Integer it : pid)
            maxPos = it > maxPos ? it : maxPos;
        int pos[] = new int[maxPos + 1];
        for(int i = 0; i < pid.size(); i++)
            pos[pid.get(i)] = i;
        // record visited
        boolean visited[] = new boolean[pid.size()];
        for(int i = 0; i < ppid.size(); i++)
        {
            if(visited[i])  continue;
            int k = i;
            List<Integer> index = new ArrayList<>();
            while(true)
            {
                if(visited[k]) break;
                visited[k] = true;
                index.add(k);
                if(ppid.get(k) == 0 || ppid.get(k) == kill)
                    break;
                k = pos[ppid.get(k)];
            }
            if(ppid.get(k) == kill)
            {
                for(Integer it: index)
                {
                    res.add(pid.get(it));
                    ppid.set(it, kill);
                }
            }
        }
        return res;
    }

    //from leetcode discussion: Recursive method
    public List<Integer> killProcess3(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> list = new LinkedList<>();
        if(kill == 0)
            return list;
        list.add(kill);
        for(int i=0; i<ppid.size(); i++)
        {
            if(ppid.get(i) == kill)
                list.addAll(killProcess3(pid, ppid, pid.get(i)));
        }
        return list;
    }

}
