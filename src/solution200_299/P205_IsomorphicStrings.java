package solution200_299;

/**
 * Created by zjw on 2017/6/21 10:33.
 */
public class P205_IsomorphicStrings {

    // "ab" "aa"
    public boolean isIsomorphic(String s, String t) {
        char sc[] = s.toCharArray(), tc[] = t.toCharArray();
        int[] mapc = new int[128], mapt = new int[128];
        for(int i = 0; i < sc.length; i++) {
            if(mapc[sc[i]] == 0 && mapt[tc[i]] == 0) {
                mapc[sc[i]] = tc[i];
                mapt[tc[i]] = sc[i];
            }
            else if(mapc[sc[i]] != tc[i] || mapt[tc[i]] != sc[i])
                return false;
        }
        return true;
    }

}
