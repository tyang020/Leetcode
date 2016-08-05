// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter = new Iterator<>();
    private Integer cacheNext = null;
    private boolean hasPeeked = false;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(iter.hasNext()) {
            cacheNext = iter.next();
            hasPeeked = true;
            return cacheNext;
        } else
            return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (hasPeeked) {
	        hasPeeked = false;
	        return cacheNext;
	    }
	    if (iter.hasNext())
	        return iter.next();
	    return null;
	}

	@Override
	public boolean hasNext() {
	    if (hasPeeked)
	        return true;
	    return iter.hasNext();
	}
}