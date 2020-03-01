package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/03 15:43
 * Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length == 0)    return false;
        return helper(sequence, 0, sequence.length - 1);
    }

    private boolean helper(int[] arr, int lt, int rt) {
        if(lt > rt)    return true;
        int k = 0;
        while(k < rt) {
            if(arr[k] > arr[rt]) break;
            k++;
        }
        int p = k;
        while(p < rt) {
            if(arr[p] < arr[rt]) break;
            p++;
        }
        return p == rt && helper(arr, lt, k - 1) && helper(arr, k, rt - 1);
    }
}
