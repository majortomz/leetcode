package solution400_499;

public class P476_NumberComplement {

	public int findComplement(int num) {
		int result = 0, mi = 1;	//the complement number of num
		while(num!=0)
		{
			result = result + mi*(1 - num%2);
			mi*=2;
			num/=2;
		}
		return result;
    }
	
	public int findComplement2(int num) {
		// leetcode discussion answer
        int mask = (Integer.highestOneBit(num) << 1) - 1;
//        while (mask < num) mask = (mask << 1) | 1;        
        num = ~num;
        return num & mask;
    }
	
	public static void main(String[] args){
		P476_NumberComplement pn = new P476_NumberComplement();
		System.out.println(pn.findComplement(5));
	}
}
