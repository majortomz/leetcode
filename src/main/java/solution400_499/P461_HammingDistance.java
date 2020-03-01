package solution400_499;

public class P461_HammingDistance {

	public int hammingDistance(int x, int y) {
		int z = x ^ y, dis = 0;
		while (z != 0) {
			if (z % 2 == 1)
				dis += 1;
			z /= 2;
		}
		return dis;
	}

	public int hammingDistance2(int x, int y) {
		String s = Integer.toBinaryString(x ^ y);
		int dis = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				dis++;
		}
		return dis;
	}

	public int hammingDistance3(int x, int y) {
		int z = x ^ y, dis = 0;
		while (z != 0) {
			dis += z & 1;
			z = z >> 1;
		}
		return dis;
	}

	public static void main(String[] args) {
		P461_HammingDistance ph = new P461_HammingDistance();
		System.out.println(ph.hammingDistance2(1, 4));
	}
}
