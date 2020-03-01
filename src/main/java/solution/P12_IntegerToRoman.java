package solution;

public class P12_IntegerToRoman {

	public String intToRoman(int num) {
	    if(num > 3999)  return "";

		char[] rc = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int[] rv = {1, 5, 10, 50, 100, 500, 1000};

		StringBuilder sb = new StringBuilder();
		int index = rv.length - 1;
		while(num > 0) {
			int count = num / rv[index];
			if(count == 0) {
				index -= 2;
				continue;
			}
			if(count <= 3) {
			    for(int i = 1; i <= count; i++)
			        sb.append(rc[index]);
            } else if(count == 4) {
			    sb.append(rc[index]);
			    sb.append(rc[index + 1]);
            }else if(count == 9) {
			    sb.append(rc[index]);
			    sb.append(rc[index + 2]);
            } else {
			    sb.append(rc[index+1]);
			    count -= 5;
			    for(int i = 1; i <= count; i++)
			        sb.append(rc[index]);
            }
            num %= rv[index];
		}
		return sb.toString();
	}
}
