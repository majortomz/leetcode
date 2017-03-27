package solution;

public class P6_ZigZagConversion {
	public String convert(String s, int numRows) {
		if(s == null || s.length() == 0)	return s;
		if(numRows <= 1)	return s;
		StringBuilder sb = new StringBuilder();
		/*
		P   A   H   N
		A P L S I I G
		Y   I   R
		*/
		// step为 第一行P到A的距离
		int step = 2*numRows - 2;
		// 逐行遍历
		for(int i=0; i<numRows; i++)
		{
			int start = i, next_step = 2*(numRows - i - 1), next;
			while(start < s.length())
			{
				sb.append(s.charAt(start));
				next = start + next_step;
				if(next_step !=0 && next_step != step && next < s.length())
					sb.append(s.charAt(next));
				start += step;
			}
		}
		return sb.toString();
	}
	
	/*
	""
	1
	""
	-1
	"PAYPALISHIRING"
	1
	*/
	public static void main(String[] args){
		P6_ZigZagConversion pz = new P6_ZigZagConversion();
		System.out.println(pz.convert("PAYPALISHIRING", 3));
	}
}
