package jsample.concurrency;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeIterator {
	/**
	 * ConcurrentHashMap is used for demonstrating fail safe iterator.
	 */
	public static final Map<String, String> map = new ConcurrentHashMap<>();

	public void print() {

		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");

		Iterator<String> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println("Iterating map values...");
			/**
			 * ConcurrentModificationException will not be thrown if there is
			 * any structural change in the map i.e. any element is added or
			 * removed in the map.
			 * 
			 * However, if any element is added or removed in the map, it may or
			 * may not be reflected in iterator.
			 */
			String key = iterator.next();
			String value = map.get(key);
			System.out.println("Key=" + key + ",Value=" + value);

			map.put(key, "1" + value);

			System.out.println("Key=" + key + ",New Value=" + map.get(key));
			/**
			 * Removing elements through remove() method of iterator will remove
			 * element from map as well as from this iterator.
			 */
			iterator.remove();
			System.out.println("Key=" + key + ",New Value=" + map.get(key));
			/**
			 * Adding a new key or removing existing key may or may not be
			 * reflected in iterator.
			 */
			map.put("D", "4");
			map.remove("C");
		}
	}
}
