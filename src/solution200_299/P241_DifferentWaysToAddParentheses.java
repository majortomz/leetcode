package solution200_299;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/10/31.
 */
public class P241_DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        if(input.length() <= 0)    return new ArrayList<>();

        char[] expr = input.toCharArray();
        List<Integer> nums = new ArrayList<>();
        List<Character> symbols = new ArrayList<>();


        int a = 0;
        for(int i = 0; i < expr.length; i++) {
            if(expr[i] >= '0' && expr[i] <= '9') {
                a = a * 10 + expr[i] - '0';
                if(i == expr.length - 1)
                    nums.add(a);
            } else {
                nums.add(a);
                a = 0;
                symbols.add(expr[i]);
            }
        }
        List<Integer> res = helper(nums, 0, nums.size() - 1, symbols, 0, symbols.size() - 1);
        return res;
    }

    public List<Integer> helper(List<Integer> nums, int startA, int endA, List<Character> symbols, int startB, int endB) {
        List<Integer> res = new ArrayList<>();
        if(startA > endA)   return res;
        else if(startA == endA) {
            res.add(nums.get(startA));
            return res;
        }

        for(int i = startA; i < endA; i++) {
            List<Integer> listA = helper(nums, startA, i, symbols, startB, i - 1);
            List<Integer> listB = helper(nums, i+1, endA, symbols, i + 1, endB);
            char symbol = symbols.get(i);
            for(Integer a : listA) {
                for(Integer b : listB)
                    res.add(getExprValue(a, b, symbol));
            }
        }

        return res;
    }

    private int getExprValue(int a, int b, char symbol) {
        if(symbol == '-')   return a-b;
        else if(symbol == '+')  return a+b;
        else return a*b;
    }

}
