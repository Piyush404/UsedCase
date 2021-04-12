import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;




public class HashMapex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String>map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		System.out.println("Original size : " +map.size());
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println("Values : " +map.values());
			if(key==2) {
				map.put(4, "e");
				map.put(5, "f");
			}
		}
	}
	}


