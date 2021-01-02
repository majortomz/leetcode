package solution500_599;

public class P520_DetectCapital {

	public boolean detectCapitalUse(String word) {
		// 记录是否出现过小写字符
		boolean flag = false;
		// 记录已经出现过的大写字符的个数
		int count = 0;
		for(int i=0; i<word.length(); i++)
		{
			if(Character.isLowerCase(word.charAt(i))) {
				flag = true;
				if(count > 1)   return false;
			}
			else {
			    if(flag == true) return false;
				count += 1;
			}
		}
		return true;
	}
}
