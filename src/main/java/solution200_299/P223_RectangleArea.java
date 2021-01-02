package solution200_299;

/**
 * Created by zjw on 2017/10/30.
 */
public class P223_RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int lenA = C - A, widthA = D - B;
        int lenB = G - E, widthB = H - F;
        int area = 0;

        int[] midA = {(A + C) / 2, (B + D) / 2}, midB = {(E + G) / 2, (F + H) / 2};
        if(Math.abs(midA[0] - midB[0]) < (lenA + lenB + 1) / 2 &&
                Math.abs(midA[1] - midB[1]) < (widthA + widthB + 1) / 2)
            area -= (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        area += (lenA * widthA + lenB * widthB);
        return area;
    }

}
