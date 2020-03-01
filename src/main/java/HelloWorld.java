import java.lang.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HelloWorld {

	private static void locks() {
		Lock reentrantLock = new ReentrantLock();
		reentrantLock.lock();
	}

	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
		new LinkedList<>();
		new ArrayList<>();
//		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//		new Hashtable<>();
		Map<String, String> hashMap = new HashMap<>();
//		Map<String, String> linkedMap = new LinkedHashMap<>();
		Map<String, String> cMap = new ConcurrentHashMap<>();
//		System.out.println("Hello, world!");
//		Executors.newFixedThreadPool(1);

		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);

		Executors.newFixedThreadPool(5);
		Executors.newScheduledThreadPool(5);

		Set<?> set = new HashSet<Integer>();
		set.add(null);
	}
}
