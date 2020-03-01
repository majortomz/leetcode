package solution900_999;

/**
 * Created by zjw on 2018/09/09 9:57
 * Description:
 */
public class P900_RLEIterator {

    class RLEIterator {

        int[] nums;
        int index = 0, cur = -1;

        public RLEIterator(int[] A) {
            nums = A;
            if(A.length != 0) {
                cur = A[0];
            }
        }

        public int next(int n) {
            if(index >= nums.length) {
                return -1;
            }

            while(n > cur) {
                n -= cur;
                index += 2;
                if(index < nums.length)
                    cur = nums[index];
                else
                    break;
            }
            if(index < nums.length) {
                cur -= n;
                return nums[index + 1];
            } else {
                return -1;
            }
        }

    }

}
