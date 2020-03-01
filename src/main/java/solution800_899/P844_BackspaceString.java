package solution800_899;

/**
 * Created by zjw on 2018/06/03 14:48
 * Description:
 */
public class P844_BackspaceString {

    public boolean backspaceCompare(String S, String T) {
        char[] sa = S.toCharArray(), st = T.toCharArray();
        int indexA = 0, indexB = 0;

        for(int i = 0; i < sa.length; i++) {
            if(sa[i] == '#') {
                indexA = Math.max(0, indexA - 1);
            } else {
                sa[indexA] = sa[i];
                indexA++;
            }
        }

        for(int i = 0; i < st.length; i++) {
            if(st[i] == '#') {
                indexB = Math.max(0, indexB - 1);
            } else {
                st[indexB] = st[i];
                indexB++;
            }
        }

        return indexA == indexB && new String(sa, 0, indexA).equals(new String(st, 0, indexB));

    }


}
