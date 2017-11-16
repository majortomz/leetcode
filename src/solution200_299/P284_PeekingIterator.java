package solution200_299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zjw on 2017/11/16.
 */
public class P284_PeekingIterator {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(1,2,3,4, 5,6));
        Iterator<Integer> iterator = arr.iterator();
        PeekingIterator pi = new PeekingIterator(iterator);
        for(int i = 0; i < arr.size(); i++) {
            System.out.println(pi.hasNext());
            System.out.println(pi.peek());
            System.out.println(pi.next());
        }
    }

}

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer peekElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if(iterator.hasNext()) {
            this.peekElement = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peekElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = this.peekElement;
        if(iterator.hasNext()) {
            this.peekElement = iterator.next();
        } else {
            this.peekElement = null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return peekElement != null;
    }
}