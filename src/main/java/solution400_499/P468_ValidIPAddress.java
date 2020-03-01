package solution400_499;


public class P468_ValidIPAddress {

	public String validIPAddress(String IP){
		if(isIPv4(IP))
			return "IPv4";
		else if(isIPv6(IP))
			return "IPv6";
		else 
			return "Neither";
	}
	
	public boolean isIPv4(String IP) {
		String[] arr = IP.split("\\.");
		if(arr.length != 4)
			return false;
		int num = 0;
		for(int i=0; i<arr.length; i++)
		{
			String s = arr[i];
			num += s.length();
			if(s.length() == 0 || (s.length() >= 2 && s.charAt(0) == '0'))
				return false;
			int count = 0;
			for(int j=0; j<s.length(); j++)
			{
				if(!Character.isDigit(s.charAt(j)))
					return false;
				count = count*10 + s.charAt(j) - '0';
			}
			if(count <0 || count > 255)
				return false;
		}
		if(num + 3 != IP.length())
			return false;
		else
			return true;
	}
	
	public boolean isIPv6(String IP) {
		String[] arr = IP.split(":");
		if(arr.length != 8)
			return false;
		int count = 0;
		for(int i=0; i<arr.length; i++)
		{
			String s = arr[i];
			count += s.length();
			if(s.length() == 0 || s.length() > 4)
				return false;
			for(int j=0; j<s.length(); j++)
			{
				char c = s.charAt(j);
				if(Character.isDigit(c))
					continue;
				else if((c >= 'a' && c<='f') || (c >='A' && c<='F'))
					continue;
				else {
					return false;
				}
			}
		}
		if(count + 7 != IP.length())
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		String s = "::::1:1:1:::::";
		System.out.println(s.split(":").length);
		for (String sp : s.split(":"))
			System.out.println(sp);
	}
}
