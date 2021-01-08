package cs1302.genlist;

import java.util.Iterator;
import cs1302.genlistadt.GenList;
import cs1302.genlist.*;

/**
 * The {@code GenIterator<T>} class implements the {@code Iterator<T>}
 * interface and supports the iteration of {@code GenList<T>} objects.
 */
public class GenIterator<T> implements Iterator<T> {

    /** The {@code GenList<T>} object that will be iterated. */
    GenList<T> list;

    /** Holds the position of the iteration. */
    int index;

    /**
     * Constructs a new {@code GenIterator<T>} object and sets the list
     * to the given {@code GenList<T>} object and sets the index to 0.
     *
     * @param list {@code GenList<T>} object
     */
    public GenIterator(GenList<T> list) {
        this.list = list;
        this.index = 0;
    } // GenIterator

    /** {@inheritDoc} */
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        } // if
        return false;
    } // hasNext

    /** {@inheritDoc} */
    public T next() {
        T next = null;
        if (this.hasNext()) {
            next = list.get(index);
            index++;
        } // if
        return next;
    } // next

} // GenIterator
