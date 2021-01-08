package cs1302.list;

import cs1302.listadt.StringList;

/**
 * The {@code AbstractStringList} class implements the {@code StringList}
 * interface and represents a List ADT.
 */
public abstract class AbstractStringList implements StringList {

    /** The size of the StringList object. */
    protected int size;

    /**
     * Constructs a {@code AbstractStringList} object with the size as 0.
     */
    public AbstractStringList() {
        this.size = 0;
    } // AbstractStringList

    /**
     * Constructs a {@code AbstractStringList} object with the values contained in other.
     *
     * @param other {@code StringList} object
     */
    public AbstractStringList(StringList other) {
        this.size = 0;
    } // AbstractStringList

    /**
     * Returns a newly constructed/empty {@code StringList} object.
     *
     * @return the respective {@code StringList} object
     */
    protected abstract StringList build();

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
     * Returns {@code true} if this list contains the specified string.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean contains(String o) {
        if (o == null) {
            throw new NullPointerException();
        } // if
        if (o.equals("")) {
            throw new IllegalArgumentException();
        } // if

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(o)) {
                return true;
            } // if
        } // for
        return false;
    } // contains


    /**
     * Returns {@code true} if this list contains the specified string, ignoring case.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean containsIgnoreCase(String o) {
        if (o == null) {
            throw new NullPointerException();
        } // if
        if (o.equals("")) {
            throw new IllegalArgumentException();
        } // if

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equalsIgnoreCase(o)) {
                return true;
            } // if
        } // for
        return false;
    } // containsIgnoreCase


    /**
     * Returns {@code true} if any string in this list contains the specified substring.
     *
     * <p>
     * {@inheritDoc}
     */
    public boolean containsSubstring(String o) {
        if (o == null) {
            throw new NullPointerException();
        } // if
        if (o.equals("")) {
            throw new IllegalArgumentException();
        } // if

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).contains(o)) {
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
    public String[] toArray() {
        String[] newArray = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newArray[i] = this.get(i);
        } // for

        return newArray;
    } // toArray

    /**
     * Appends the specified string to the end of this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract boolean add(String s);

    /**
     * Appends the strings contained in the specified list to the end of this list,
     * in the order in which they appear in the specified list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract boolean add(StringList sl);

    /**
     * Inserts the specified string at the specified position in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract boolean add(int index, String s);

    /**
     * Inserts the strings containted in the specified list at the specified position in this list,
     * in the order in which they appear in the specified list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract boolean add(int index, StringList sl);

    /**
     * Returns the string at the specified position in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract String get(int index);

    /**
     * Replaces the string at the specified position in this list with the specified element.
     *
     * <p>
     * {@inheritDoc}
     */
    public String set(int index, String s) {
        if (s == null) {
            throw new NullPointerException();
        } // if
        if (s.equals("")) {
            throw new IllegalArgumentException();
        } // if
        if ((index < 0) || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        } // if

        String previous = this.remove(index);
        this.add(index, s);

        return previous;
    } // set

    /**
     * Removes the string at the specified position in this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract String remove(int index);

    /**
     * Returns the index of the first occurence of the specified string in this list,
     * or -1 if this list does not contain the string.
     *
     * <p>
     * {@inheritDoc}
     */
    public int indexOf(String s) {
        if (s == null) {
            throw new NullPointerException();
        } // if
        if (s.equals("")) {
            throw new IllegalArgumentException();
        } // if

        for (int i = 0; i < this.size(); i++) {
            if (s.equals(this.get(i))) {
                return i;
            } // if
        } // for

        return -1;
    } // indexOf

    /**
     * Returns the index of the first occurence of the specified string, ignoring case,
     * in this list, or -1 if this list does not contain the string.
     *
     * <p>
     * {@inheritDoc}
     */
    public int indexOfIgnoreCase(String s) {
        if (s == null) {
            throw new NullPointerException();
        } // if
        if (s.equals("")) {
            throw new IllegalArgumentException();
        } // if

        for (int i = 0; i < this.size(); i++) {
            if (s.equalsIgnoreCase(this.get(i))) {
                return i;
            } // if
        } // for

        return -1;
    } // indexOf

    /**
     * Removes all of the strings from this list.
     *
     * <p>
     * {@inheritDoc}
     */
    public abstract void clear();

    /**
     * Builds and returns a new {@code StringList} from this list without any
     * duplicate strings.
     *
     * <p>
     * {@inheritDoc}
     *
     * <p>
     * Utilizes the {@link #build()} method to create a new {@code StringList}.
     */
    public StringList distinct() {
        StringList sl = this.build();

        for (int i = 0; i < this.size(); i++) {
            if (!(sl.contains(this.get(i)))) {
                sl.add(this.get(i));
            } // if
        } // for

        return sl;
    } // distinct

    /**
     * Builds and returns a new {@code StringList} from this list in reverse order.
     *
     * <p>
     * {@inheritDoc}
     *
     * <p>
     * Utilizes the {@link #build()} method to create a new {@code StringList}.
     */
    public StringList reverse() {
        StringList sl = this.build();

        for (int i = this.size() - 1; i >= 0; i--) {
            sl.add(this.get(i));
        } // for

        return sl;
    } // reverse

    /**
     * Returns a {@code String} representation of this list with all strings
     * directly concatenated in order.
     *
     * <p>
     * {@inheritDoc}
     */
    public String makeString(String sep) {
        String s = "";
        if (this.size() != 0) {
            s = this.get(0);
            for (int i = 1; i < this.size(); i++) {
                s += sep + this.get(i);
            } // for
        } // if

        return s;
    } // makeString

    /**
     * Builds and returns a new {@code StringList} that contains the strings from
     * this list between {@code fromIndex} (inclusive, and {@code toIndex} (exclusive).
     *
     * <p>
     * {@inheritDoc}
     *
     * <p>
     * Utilizes the {@link #build()} method to create a new {@code StringList}.
     */
    public StringList splice(int fromIndex, int toIndex) {
        if ((fromIndex < 0) || (toIndex > this.size())) {
            throw new IndexOutOfBoundsException();
        } // if
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        } // if
        StringList sl = this.build();

        for (int i = fromIndex; i < toIndex; i++) {
            sl.add(this.get(i));
        } // for

        return sl;
    } // splice

} // AbstractStringList
