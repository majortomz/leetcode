package ali;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/08/31 10:22
 * Description:
 */
public class Permutation {


    public static List<String> permutation(String s) {
        List<String> res = new ArrayList<>();

        if(s == null || s.length() == 0) {
            return res;
        }

        char[] words = s.toCharArray();

//        helper(words, new boolean[words.length], res, new char[words.length], 0);
        helper2(words, words.length - 1, res);
        return res;
    }

    public static void helper2(char[] words, int bound, List<String> res) {
        if(bound == 0) {
            res.add(new String(words));
        }

        for(int i = 0; i <= bound; i++) {
            swap(words, i, bound);
            helper2(words, bound - 1, res);
            swap(words, i, bound);
        }
    }

    public static void swap(char[] words, int i, int j) {
        char tmp = words[i];
        words[i] = words[j];
        words[j] = tmp;
    }

    public static void helper(char[] words, boolean[] visited, List<String> res, char[] path, int size) {
        if(size == path.length) {
            res.add(new String(path));
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            path[size] = words[i];
            helper(words, visited, res, path, size + 1);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        String s = "abcd";
        List<String> res = permutation(s);
        for(String seq: res) {
            System.out.println(seq);
        }
        System.out.println(res.size());
    }


}
