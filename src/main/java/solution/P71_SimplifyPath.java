package solution;

import java.util.LinkedList;

public class P71_SimplifyPath {

	public String simplifyPath(String path) {
		if(path == null || path.length() == 0)	return "/";
		LinkedList<String> list = new LinkedList<String>();
		int start, end;
		String dir;
		for(int i=0; i<path.length(); i++)
		{
			
			if(path.charAt(i) == '/')
				continue;
			start = i;
			while(i<path.length() && path.charAt(i) != '/')
				i++;
			end = i;
			dir = path.substring(start, end);
			System.out.println(dir);
			if(dir.equals(".."))
			{
				if(!list.isEmpty())
					list.removeLast();
			}
			else if(!dir.equals("."))
			{
				list.add(dir);
			}
		}
		StringBuilder sb = new StringBuilder();
		if(list.size() == 0) 
			sb.append("/");
		else
		{
			for(int i=0; i<list.size(); i++)
			{
				sb.append("/");
				sb.append(list.get(i));
			}
		}
		return sb.toString();
	}
	/*
	 *  TestCase : /../
	 *  	/home//test
	 */
	public static void main(String[] args){
		P71_SimplifyPath ps = new P71_SimplifyPath();
		System.out.println(ps.simplifyPath("/../"));
	}
}
