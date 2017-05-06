package jsample.iterator;

/**
 * Iterator design pattern in one of the behavioral pattern.
 * 
 * Iterator pattern is used to provide a standard way to traverse through a
 * group of Objects.
 *
 * This pattern is useful when client program need access to elements in a set
 * without access to the entire representation. When client program need a
 * uniform traversal interface, and multiple traversals may happen across
 * elements, iterator is a good choice.
 * 
 * Iterator pattern is widely used in Java Collection Framework. Iterator
 * interface in Java provides methods for traversing through a collection.
 * 
 * Iterator pattern is not only about traversing through a collection, there can
 * be different kind of iterators based on requirements.
 * 
 * Iterator design pattern hides the actual implementation of traversal through
 * the collection and client programs just use iterator methods.
 */

public interface IntegerRangeIterator {

	public boolean hasNext();

	public Integer next();

}
