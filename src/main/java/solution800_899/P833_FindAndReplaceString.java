package solution800_899;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/05/13 9:50
 * Description:
 */
public class P833_FindAndReplaceString {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if(indexes == null || indexes.length == 0 || S == null) {
            return S;
        }

        StringBuilder builder = new StringBuilder();
        List<int[]> poses = new ArrayList<>();
        for(int i = 0; i < indexes.length; i++) {
            if(S.startsWith(sources[i], indexes[i])) {
                // 字符串位置，在原始数组的下标
                poses.add(new int[]{indexes[i], i});
            }
        }

        poses.sort((o1, o2) -> (o1[0] - o2[0]));

        int nextStart = 0;

        for(int[] pos : poses) {
            if(pos[0] > nextStart) {
                builder.append(S.substring(nextStart, pos[0]));
            }

            builder.append(targets[pos[1]]);
            nextStart = pos[0] + sources[pos[1]].length();
        }
        if(nextStart < S.length()) {
            builder.append(S.substring(nextStart, S.length()));
        }
        return builder.toString();
    }

}
