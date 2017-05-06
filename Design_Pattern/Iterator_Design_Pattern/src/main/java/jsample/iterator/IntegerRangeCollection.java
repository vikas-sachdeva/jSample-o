package jsample.iterator;

public interface IntegerRangeCollection {

	public void addRange(int startValue, int endValue);

	public void removeRange(int startValue, int endValue);
	
	public IntegerRangeIterator evenIterator();
	
	public IntegerRangeIterator oddIterator();

}
