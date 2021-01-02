package solution400_499;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/01/27 15:43
 * Description:
 */
public class P412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            String item = "";
            if(i % 3 == 0)
                item += "Fizz";
            if(i % 5 == 0)
                item += "Buzz";
            if(i % 3 != 0 && i % 5 != 0)
                item += i;
            list.add(item);
        }
        return list;
    }

}
