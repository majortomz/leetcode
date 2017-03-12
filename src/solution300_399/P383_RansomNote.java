package solution300_399;

public class P383_RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] dict = new int[256];
		for(int i=0; i<magazine.length(); i++)
		{
			dict[magazine.charAt(i)]++;
		}
		for(int i=0; i<ransomNote.length(); i++)
		{
			if(dict[ransomNote.charAt(i)] > 0)
			{
				dict[ransomNote.charAt(i)]--;
			}
			else{
				return false;
			}
		}
		return true;
	}
}
