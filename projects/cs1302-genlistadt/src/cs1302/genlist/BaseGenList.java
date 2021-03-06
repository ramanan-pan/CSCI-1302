package cs1302.genlist;

import cs1302.genlistadt.GenList;
import java.util.function.IntFunction;
import java.util.Iterator;
import cs1302.genlist.GenIterator;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BinaryOperator;

/**
 * The {@code BaseGenList<T>} class implements the {@code GenList<T>}
 * interface and represents a List ADT.
 */
public abstract class BaseGenList<T> implements GenList<T> {

    /** The size of the {@code BaseGenList<T>} object. */
    protected int size;

    /**
     * Constructs a {@code BaseGenList<T>} object with the size as 0.
     */
    public BaseGenList() {
        this.size = 0;
    } // BaseGenList

    /**
     * Constructs a {@code BaseGenList<T>} object with the values contained in other.
     *
     * @param other {@code GenList<U>} object
     * @param <U> class type which is sub-class of {@code T}
     */
    public <U extends T> BaseGenList(GenList<U> other) {
        this.size = 0;
    } // BaseGenList

    /**
     * Returns a newly constructed/empty {@code GenList<T>} object.
     *
     * @return the respective {@code GenList<T>} object
     */
    protected abstract GenList<T> build();

    /**
     * Returns the number of elements in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public int size() {
        if (this.size > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } // if

        return this.size;
    } // size

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    } // isEmpty

    /**
     * Returns {@code true} if this list contains the specified object.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean contains(T o) {
        if (o == null) {
            throw new NullPointerException();
        } // if

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(o)) {
                return true;
            } // if
        } // for
        return false;
    } // contains

    /**
     * Returns a new array containing all of the strings in this list in proper sequence.
     *
     * <p>
     * {@inheritDoc}
     */
    public T[] toArray(IntFunction<T[]> gen) {
        T[] newArray = gen.apply(this.size);

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.get(i);
        } // for

        return newArray;
    } // toArray

    /**
     * Appends the specified object to the end of this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract boolean add(T obj);

    /**
     * Appends the objects contained in the specified list to the end of this list,
     * in the order in which they appear in the specified list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract <U extends T> boolean add(GenList<U> list);

    /**
     * Inserts the specified object at the specified position in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract boolean add(int index, T obj);

    /**
     * Inserts the objects contained in the specified list at the specified position in this list,
     * in the order in which they appear in the specified list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract <U extends T> boolean add(int index, GenList<U> list);

    /**
     * Returns the object at the specified position in the list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract T get(int index);

    /**
     * Replaces the object at the specified position in this list with the specified element.
     *
     * <p>
     * {@inheritDoc}
     */
    public T set (int index, T obj) {
        if (obj == null) {
            throw new NullPointerException();
        } // if
        if ((index < 0) || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        } // if

        T previous = this.remove(index);
        this.add(index, obj);

        return previous;
    } // set

    /**
     * Removes the object at the specified position in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract T remove(int index);


    /**
     * Returns the index of the first occurence of the specified object in this list,
     * or -1 if this list does not contain the object.
     *
     * <p>
     * {@inheritDoc}
     */
    public int indexOf(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        } // if

        for (int i = 0; i < this.size(); i++) {
            if (obj.equals(this.get(i))) {
                return i;
            } // if
        } // for

        return -1;
    } // indexOf

    /**
     * Removes all of the objects from this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract void clear();


    /**
     * Builds and returns a new {@code GenList<T>} from this list without any
     * duplicate objects.
     *
     * <p>
     * {@inheritDoc}
     *
     * <p>
     * Utilizes the {@link #build()} method to create a new {@code GenList<T>}.
     */
    public GenList<T> distinct() {
        GenList<T> gl = this.build();

        for (int i = 0; i < this.size(); i++) {
            if (!(gl.contains(this.get(i)))) {
                gl.add(this.get(i));
            } // if
        } // for

        return gl;
    } // distinct

    /**
     * Builds and returns a new {@code GenList<T>} from this list in reverse order.
     *
     * <p>
     * {@inheritDoc}
     *
     * <p>
     * Utilizes the {@link #build()} method to create a new {@code GenList<T>}.
     */
    public GenList<T> reverse() {
        GenList<T> gl = this.build();

        for (int i = this.size() - 1; i >= 0; i--) {
            gl.add(this.get(i));
        } // for

        return gl;
    } // reverse

    /**
     * Returns a string representation of this list with all strings
     * separated by a {@code sep}.
     *
     * <p>
     * {@inheritDoc}
     */
    public String makeString(String sep) {
        String s = "";
        if (this.size() != 0) {
            s = this.get(0).toString();
            for (int i = 1; i < this.size(); i++) {
                s += sep + this.get(i).toString();
            } // for
        } // if

        return s;
    } // makeString


    /**
     * Builds and returns a new {@code GenList<T>} that contains the objects from
     * this list between {@code fromIndex} (inclusive, and {@code toIndex} (exclusive).
     *
     * <p>
     * {@inheritDoc}
     *
     * <p>
     * Utilizes the {@link #build()} method to create a new {@code GenList<T>}.
     */
    public GenList<T> splice(int fromIndex, int toIndex) {
        if ((fromIndex < 0) || (toIndex > this.size())) {
            throw new IndexOutOfBoundsException();
        } // if
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        } // if
        GenList<T> gl = this.build();

        for (int i = fromIndex; i < toIndex; i++) {
            gl.add(this.get(i));
        } // for

        return gl;
    } // splice

    /**
     * Returns a new iterator over the elements in this list in proper sequence.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new GenIterator<T>(this);
    } // iterator

    /**
     * Returns a minimal element of this list according to the provided {@code Comparator}.
     *
     * <p>
     * {@inheritDoc}
     */
    public T min(Comparator<T> c) {
        if (c == null) {
            throw new NullPointerException();
        } // if
        if (this.isEmpty()) {
            return null;
        } // if
        T min = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            if (c.compare(min, this.get(i)) >=  0) {
                min = this.get(i);
            } // if
        } // for

        return min;
    } // min

    /**
     * Returns a maximal element of this list according to the provided {@code Comparator}.
     *
     * <p>
     * {@inheritDoc}
     */
    public T max(Comparator<T> c) {
        if (c == null) {
            throw new NullPointerException();
        } // if
        if (this.isEmpty()) {
            return null;
        } // if
        T max = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            if (c.compare(max, this.get(i)) <=  0) {
                max = this.get(i);
            } // if
        } // for

        return max;
    } // max

    /**
     * Returns a new {@code GenList<T>} object consisting of the elements of this list
     * that pass the test specified by the given {@code Predicate}.
     *
     * <p>
     * {@inheritDoc}
     */
    public GenList<T> filter(Predicate<T> p) {
        if (p == null) {
            throw new NullPointerException();
        } // if
        GenList<T> gl = this.build();
        for (T e : this) {
            if (p.test(e)) {
                gl.add(e);
            } // if
        } // for

        return gl;
    } // filter

    /**
     * Returns a new {@code GenList<R>} object consisting of elements of this list
     * transformed by the given {@code Function}.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract <R> GenList<R> map(Function<T,R> f);

    /**
     * Returns the result of repeatedly applying some combining operation to
     * the elements of this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public T reduce(T start, BinaryOperator<T> f) {
        if (f == null) {
            throw new NullPointerException();
        } // if
        T result = start;
        for (T e : this) {
            if (f.apply(result, e) == null) {
                throw new NullPointerException();
            } // if
            result = f.apply(result, e);
        } // for

        return result;
    } // reduce

    /**
     * Returns whether all the elements of this list that pass the test specified by
     * the given {@code Predicate}.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean allMatch(Predicate<T> p) {
        if (p == null) {
            throw new NullPointerException();
        } // if
        for (T e : this) {
            if (!(p.test(e))) {
                return false;
            } // if
        } // for

        return true;
    } // allMatch


    /**
     * Returns whether at least one element of this list that passes the test specified
     * by the given {@code Predicate}.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean anyMatch(Predicate<T> p) {
        if (p == null) {
            throw new NullPointerException();
        } // if
        for (T e : this) {
            if (p.test(e)) {
                return true;
            } // if
        } // for

        return false;
    } // anyMatch

} // BaseGenList
