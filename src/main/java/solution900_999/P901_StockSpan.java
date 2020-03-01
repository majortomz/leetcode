package solution900_999;

import java.util.Stack;

/**
 * Created by zjw on 2018/09/09 10:16
 * Description:
 */
public class P901_StockSpan {

    class StockSpanner {

        class Item {
            int price;
            int span;

            public Item(int price, int span) {
                this.price = price;
                this.span = span;
            }
        }

        Stack<Item> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            Item item = null;
            while(!stack.isEmpty() && stack.peek().price <= price) {
                item = stack.pop();
                span += item.span;
            }
            if(item == null) {
                item = new Item(price, 1);
            } else {
                item.price = price;
                item.span = span;
            }
            stack.push(item);
            return item.span;
        }

    }


}
