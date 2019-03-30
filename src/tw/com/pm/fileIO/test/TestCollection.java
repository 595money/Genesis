package tw.com.pm.fileIO.test;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TestCollection {
	public static void main(String[] args) {
//		ArrayList<String> strList = new ArrayList<String>();
//		strList.add("1");
//		strList.add("1");
//		Iterator i =strList.iterator();
//		while(i.hasNext()){
//			System.out.print(i.next());
//			
//		}
		
//		Set s = new Set();
//		HashMap<Integer,String>m = new HashMap<Integer,String>(); 
//		m.put(1, "A");
//		m.put(2, "B");
//		m.put(3, "C");
//		m.put(4, "D");
//		m.put(5, "E");
//		m.put(6, "F");
//		m.put(7, "G");
//		m.put(8, "H");
//		m.put(1, "AA");
//		
//		System.out.println("m.values() :" + m.values());
//		System.out.println("m.entrySet() :" + m.entrySet());
//		System.out.println("m.keySet() :" + m.keySet());
//		for(Object o :m.keySet()){
//			System.out.println(m.get(o));
//			
//		}
//		
		PriorityQueue pq = new PriorityQueue();
		pq.add("2");
		pq.add("1");
		pq.add("1");
		pq.add("3");
		
		
		System.out.println(pq.poll());
		
	}
}
