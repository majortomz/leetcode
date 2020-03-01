package solution;

import java.util.ArrayList;
import java.util.List;

public class P93_RestoreIPAddress {

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		// 相当于把s分成4段，index数组记录每段在s中的起始坐标
		int[] index = new int[4];
		getCombination(result, s, 0, 0, index);
		return result;
	}

	/**
	 * @param result	记录所有可能的结果IP字符串
	 * @param s			原始的字符串
	 * @param count		记录已经获得的分段的个数
	 * @param sum		记录当前s中已经遍历的字符的个数
	 * @param index		index数组记录每段在s中的起始坐标
	 */
	public void getCombination(List<String> result, String s, int count, int sum, int index[])
	{
		int rest_sum = s.length() - sum, rest_count = 4 - count;
		// 每段最少1位，最多3位；如果后面的位数不足或过多，则直接返回
		if(rest_sum < rest_count || rest_sum > 3*rest_count)
			return;
		// 已经获得的分段个数加一
		count++;
		for(int i=1; i<=3; i++)
		{
			if(sum + i > s.length())
				continue;
			// 记录当前分段的起始位置
			index[count-1] = sum;
			// 记录当前分段的起始位置，终止位置+1，得到该分段的数值
			int left = sum, right = sum+i;
			// 如果到了最后一个分段，但是最后分段的终止位置+1不等于s长度，则继续
			if(count == index.length && right != s.length())
				continue;
			int value = Integer.valueOf(s.substring(left, right));
			// 数值应在[0, 255]区间内，且如果非零的话，不能有leading zero 如"024"
			if(value >=0 && value <= 255 && (i== 1 || s.charAt(left) != '0')){
				if(count < 4)
					getCombination(result, s, count, sum+i, index);
				else if(count == 4)
				{
					StringBuilder sb = new StringBuilder(s);
					for(int j=1; j<index.length; j++)
					{
						sb.insert(index[j] + j-1, '.');
					}
					result.add(sb.toString());
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		// StringBuilder sb = new StringBuilder("saaa");
		// System.out.println(sb.insert(0, '.'));
		P93_RestoreIPAddress pr = new P93_RestoreIPAddress();
		System.out.println(pr.restoreIpAddresses("010010"));
	}

}
