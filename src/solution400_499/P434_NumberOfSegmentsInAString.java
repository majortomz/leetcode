package solution400_499;

public class P434_NumberOfSegmentsInAString {
	public int countSegments(String s) {
        int count = 0;
        boolean flag = false;
        for(int i=0; i<s.length(); i++)
        {
        	if(flag == false && s.charAt(i) != ' ')
        	{
        		flag = true;
        		count++;
        	}
        	else if(flag == true && s.charAt(i) == ' ')
        	{
        		flag = false;
        	}
        }
        return count;
    }
	
	public static void main(String[] args){
		P434_NumberOfSegmentsInAString pn = new P434_NumberOfSegmentsInAString();
		pn.countSegments("  A  ");
	}
}
