package test;

import java.util.Stack;

/**
 * Created by zjw on 2018/09/11 16:22
 * Description:
 */
public class Calculator {

    public static int calculator(String expr) {
        Stack<Character> tokens = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        expr = '(' + expr + ')';

        int[] prior = new int[256];
        setP(prior);

        for(int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if(Character.isDigit(c)) {
                int num = expr.charAt(i) - '0';
                while(i + 1 < expr.length() && Character.isDigit(expr.charAt(i + 1))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                }
                nums.push(num);
            } else if(c == '(') {
                tokens.push('(');
            } else if(c == ')'){
                while(tokens.peek() != '(') {
                    int b = nums.pop(), a = nums.pop();
                    nums.push(calc(a, b, tokens.pop()));
                }
                tokens.pop();   // pop '('
            } else if(c == '-' || c == '+' || c == '*' || c == '/') {
                if(tokens.peek() != '(' && prior[tokens.peek()] >= prior[c]) {
                    int b = nums.pop(), a = nums.pop();
                    nums.push(calc(a, b, tokens.pop()));
                }
                tokens.push(c);
            }
        }

        return nums.peek();
    }

    public static int calc(int a, int b, char c) {
        switch(c) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static void setP(int[] ops) {
        // (  -+ */ )
        ops['('] = 4;
        ops['*'] = ops['/'] = 3;
        ops['-'] = ops['+'] = 2;
        ops[')'] = 1;
    }

    public static void main(String[] args) {
        String[] test = {"1+2*3", "1+2*(5*(6-2))*(5-4)", "1-2*3", "2*(3+3-1)-6/(4-1-1)"};
        for(String expr : test) {
            System.out.println(expr);
            System.out.println(calculator(expr));
        }
    }

}
