package leetcode_ms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/08/05 16:10
 * Description:
 */
public class P71 {

    public String simplifyPath(String path) {
        List<String> paths = new ArrayList<>();
        for(String dir: path.split("/")) {
            if(dir.length() == 0 || dir.equals(".")) {
                continue;
            }
            if(dir.equals("..")) {
                if(paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            } else {
              paths.add(dir);
            }
        }

        if(paths.size() == 0) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            for(String dir: paths) {
                sb.append("/").append(dir);
            }
            return sb.toString();
        }

    }

}
