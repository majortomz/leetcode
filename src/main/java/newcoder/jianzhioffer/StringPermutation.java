package newcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by zjw on 2018/03/05 17:14
 * Description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

 */
public class StringPermutation {


    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.length() == 0)    return list;
        helper(list, new StringBuilder(), new boolean[str.length()], str.toCharArray());
        return list;
    }

    public void helper(ArrayList<String> list, StringBuilder path, boolean[] visited, char[] arr) {
        if(path.length() == visited.length) {
            if(!list.contains(path.toString()))
                list.add(path.toString());
        } else {
            for(int i = 0; i < arr.length; i++) {
                if(visited[i])  continue;
                visited[i] = true;
                helper(list, path.append(arr[i]), visited, arr);
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        System.out.println(sp.Permutation("abac"));
    }

}
