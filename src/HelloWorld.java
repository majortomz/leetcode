import java.lang.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HelloWorld {

	private static void locks() {
		Lock reentrantLock = new ReentrantLock();
		reentrantLock.lock();
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		new LinkedList<>();
		new ArrayList<>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		new Hashtable<>();
		Map<String, String> hashMap = new HashMap<>();
		Map<String, String> linkedMap = new LinkedHashMap<>();
		Map<String, String> cMap = new ConcurrentHashMap<>();
		System.out.println("Hello, world!");
	}
}
