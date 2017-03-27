package solution100_199;

public class P165_CompareVersionNumbers {

	public int compareVersion(String version1, String version2) {
		int i, j, a1, a2;
		String v1 = version1, v2 = version2;
		for(i=0, j=0; i<v1.length() || j<v2.length(); i++, j++)
		{
			a1 = a2 = 0;
			while(i<v1.length() && v1.charAt(i) != '.')
			{
				a1 = a1*10 + v1.charAt(i) - '0';
				i++;
			}
			while(j<v2.length() && v2.charAt(j) != '.')
			{
				a2 = a2*10 + v2.charAt(j) - '0';
				j++;
			}
			if(a1 == a2)
				continue;
			else if(a1 < a2)
				return -1;
			else
				return 1;
		}
		return 0;
	}
	
	public static void main(String[] args){
		String s1 = "2.24.444", s2 = "2.24.444";
		P165_CompareVersionNumbers pc = new P165_CompareVersionNumbers();
		System.out.println(pc.compareVersion(s1, s2));
	}
}
