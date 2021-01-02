package solution800_899;

/**
 * Created by zjw on 2018/03/25 9:33
 * Description:
 */
public class P806_NumberOfLines {

    public int[] numberOfLines(int[] widths, String S) {
        int curUnits = 0, count = 0, lines = 0, lastWidth = 0;
        for(char c : S.toCharArray()) {
            int width = widths[c - 'a'];
            if(curUnits < width) {
                curUnits = 100;
                count = 0;
                lastWidth = 0;
            }
            count++;
            if(count == 1)   lines++;
            lastWidth += width;
            curUnits -= width;
        }
        return new int[]{lines, lastWidth};
    }

}
