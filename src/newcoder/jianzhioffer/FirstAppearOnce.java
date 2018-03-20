package newcoder.jianzhioffer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by zjw on 2018/03/09 21:31
 * Description:
 */
public class FirstAppearOnce {

    LinkedList<Character> list = new LinkedList<Character>();
    boolean[] map = new boolean[256];
    public void Insert(char ch)
    {
        if(!map[ch]) {
            list.add(ch);
            map[ch] = true;
        } else {
            Iterator<Character> iter = list.iterator();
            while(iter.hasNext()) {
                if(iter.next() == ch) {
                    iter.remove();
                    break;
                }
            }
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return list.size() == 0 ? '#' : list.get(0);
    }
}
