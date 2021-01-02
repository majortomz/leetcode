package solution;

import java.util.Stack;

/**
 * Created by zjw on 2018/04/06 15:50
 * Description:
 */
public class P84_LargestRectangleInHistogam {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int[] left = new int[len], right = new int[len];

        for (int i = 1; i < heights.length; i++) {
            int index = i - 1;
            while (index >= 0 && heights[i] <= heights[index]) {
                index = left[index] - 1;
            }
            left[i] = index + 1;
        }

        int res = heights[len - 1] * (len - left[len - 1]);
        right[len - 1] = len - 1;
        for (int i = heights.length - 2; i >= 0; i--) {
            int index = i + 1;
            while (index < len && heights[i] <= heights[index]) {
                index = right[index] + 1;
            }
            right[i] = index - 1;
            res = Math.max(res, heights[i] * (right[i] - left[i] + 1));
        }

        return res;
    }

    private class Solution2 {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            Stack<Integer> stack = new Stack<>();
            int maxArea = 0;
            for (int i = 0; i <= len; i++) {
                int h = i == len ? 0 : heights[i];
                if (stack.isEmpty() || h >= heights[stack.peek()]) {
                    stack.push(i);
                } else {
                    int tp = stack.pop();
                    maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                    i--;
                }
            }
            return maxArea;
        }
    }

    // O(n) using stack
    // from https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    public class Solution3 {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();

            int maxArea = 0;
            int tp;
            int areaTp;

            int i = 0;
            while(i < heights.length) {
                if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                    stack.push(i++);
                } else {
                    tp = stack.pop();
                    areaTp = heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                    if(maxArea < areaTp)
                        maxArea = areaTp;
                }
            }
            while(!stack.isEmpty()) {
                tp = stack.pop();
                areaTp = heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if(maxArea < areaTp) {
                    maxArea = areaTp;
                }
            }
            return maxArea;
        }
    }

}
