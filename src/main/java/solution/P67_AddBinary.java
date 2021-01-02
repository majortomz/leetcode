package solution;

public class P67_AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1;
		int c = 0;
		while (i >= 0 || j >= 0 || c != 0) {
			c += (i >= 0 ? a.charAt(i) - '0' : 0);
			c += (j >= 0 ? b.charAt(j) - '0' : 0);
			i--;
			j--;
			sb.insert(0, c % 2);
			c /= 2;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		System.out.println("" + a);
	}
}
