package solution500_599;

import java.util.Arrays;
import java.util.List;

public class P539_MinimumTimeDifference {

	public int findMinDifference(List<String> timePoints) {
		int[] times = new int[timePoints.size() + 1];
		int len = timePoints.size(), min = Integer.MAX_VALUE;
		int h, m;
		for (int i = 0; i < len; i++) {
			String[] ts = timePoints.get(i).split(":");
			h = Integer.valueOf(ts[0]);
			m = Integer.valueOf(ts[1]);
			times[i] = h * 60 + m;
			min = times[i]<min?times[i]:min;
		}
		Arrays.sort(times, 0, len);
		times[len] = min + 24 * 60;
		min = Integer.MAX_VALUE;
		for(int i=1; i<times.length; i++)
		{
			int diff = times[i] - times[i-1];
			min = diff<min?diff:min;
		}
		return min;
	}

	public static void main(String[] args){
		int[] a = {42, 23, 1, 5};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
