package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/09 10:27
 * Description: 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class MultiplyArray {

    public int[] multiply(int[] A) {
        if(A == null || A.length == 1)    return A;
        int[] left = new int[A.length], right = new int[A.length];
        left[0] = A[0];
        right[A.length - 1] = A[A.length - 1];
        for(int i = 1; i < A.length; i++) {
            left[i] = A[i] * left[i -1];
        }
        for(int i = A.length - 2; i >= 0; i--) {
            right[i] = A[i] * right[i + 1];
        }

        int[] B = new int[A.length];
        B[0] = right[1];
        B[B.length - 1] = left[B.length - 2];
        for(int i = 1; i <= B.length - 2; i++) {
            B[i] = left[i - 1] * right[i + 1];
        }
        return B;
    }

    public int[] multiply2(int[] A) {
        if(A == null || A.length <= 1)  return A;
        int[] B = new int[A.length];
        int tmp = 1;
        B[0] = 1;
        for(int i = 1; i < A.length; i++) {
            tmp *= A[i - 1];
            B[i] = tmp;
        }
        tmp = 1;
        for(int i = A.length - 2; i >=0; i--) {
            tmp *= A[i + 1];
            B[i] *= tmp;
        }
        return B;
    }

}
