package mytry;

class Small {
		int x = 0;
		Small(int x) {
			this.x = x;
		}
	}

public class ClassTest {

	Small s1, s2;
	
	ClassTest() {
		this.s1 = new Small(5);
		this.s2 = new Small(6);
	}
	
	public void alter(Small a, Small b){
		a = b;
	}
	
	public static void main(String[] args){
		ClassTest ct = new ClassTest();
		ct.alter(ct.s1, ct.s2);
		System.out.println(ct.s1.x);
		System.out.println(ct.s2.x);
	}
}
