package jsample.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastIterator {
	/**
	 * HashMap is used for demonstrating fail fast iterator.
	 */
	private static final Map<String, String> map = new HashMap<>();

	public void print() {

		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");

		Iterator<String> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println("Iterating map values...");
			/**
			 * ConcurrentModificationException will be thrown from next() method
			 * of iterator, if there is any structural change in the map i.e.
			 * any element is added or removed in the map directly.
			 */
			String key = iterator.next();
			String value = map.get(key);
			System.out.println("Key=" + key + ",Value=" + value);
			/**
			 * If value of any existing key is modified, it will not result in
			 * ConcurrentModificationException
			 */
			map.put(key, "1" + value);

			System.out.println("Key=" + key + ",New Value=" + map.get(key));
			/**
			 * Removing elements through remove() method of iterator will remove
			 * element from map as well as from this Iterator but it will not
			 * result in ConcurrentModificationException
			 */
			iterator.remove();
			System.out.println("Key=" + key + ",New Value=" + map.get(key));
			/**
			 * Adding a new key or removing existing key through map methods
			 * will make structural changes in the map which will result in
			 * ConcurrentModificationException in subsequent next() or remove()
			 * method call of Iterator.
			 * 
			 * If any element which is not present in map, is removed. It will
			 * not make any change in the map and hence it will not result in
			 * ConcurrentModificationException
			 * 
			 */
			map.put("D", "4");
			// map.remove("E");
		}
	}
}