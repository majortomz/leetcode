package solution400_499;

/**
 * Created by zjw on 2018/01/28 16:30
 * Description:
 */
public class P424_LongestRepeatingChar {

    // O(n^2)
    public int characterReplacement(String s, int k) {
        if(s.length() == 0 || s.length() < k || k < 0)
            return 0;
        int max = 0;
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            int maxCount = 0, otherCount = 0;
            char maxChar = arr[i];
            int[] map = new int[26];
            for(int j = i; j >= 0; j--) {
                int count = ++map[arr[j] - 'A'];
                if(arr[j] == maxChar) {
                    maxCount = count;
                } else if(count > maxCount) {
                    otherCount = otherCount - count + 1 + maxCount;
                    maxCount = count;
                    maxChar = arr[j];
                } else {
                    otherCount++;
                }
                if(otherCount <= k) {
                    // if(i - j + 1 > max)
                    // System.out.println(s.substring(j, i + 1));
                    max = Math.max(max, i - j + 1);
                }
            }
        }
        return max;
    }

    // O(n)
    public int characterReplacement2(String s, int k) {
        if(s.length() == 0 || s.length() < k) {
            return 0;
        }

        int start = 0, maxCount = 0, maxLength = 0;
        int[] map = new int[26];
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            maxCount = Math.max(maxCount, ++map[arr[i] - 'A']);
            while(i - start + 1 - maxCount > k) {
                map[arr[start] - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
