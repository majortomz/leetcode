package yunyinyue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for(int i = 1; i <= 4000; i++) {
            list.add(i);
        }

        int count = 0;
        while(list.size() > 1) {
            Iterator<Integer> iter = list.iterator();
            while(iter.hasNext()) {
                iter.next();
                count = count == 3 ? 1 : count + 1;
                if(count == 3) {
                    iter.remove();
                }
            }
        }

        System.out.println(list.get(0));
    }

}
