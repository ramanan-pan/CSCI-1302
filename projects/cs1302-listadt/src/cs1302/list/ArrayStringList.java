package cs1302.list;

import cs1302.listadt.StringList;

/**
 * The {@code ArrayStringList} class extends the {@code AbstractStringList} class
 * which implements the {@code StringList} interface and represents a List ADT.
 */
public class ArrayStringList extends AbstractStringList {

    /** The array that hold the values of the {@code ArrayStringList}. */
    private String[] array;

    /**
     * Constructs a {@code LinkedStringList} object with the size as 0
     * and sets {@code array} length to 6.
     */
    public ArrayStringList() {
        super();
        array = new String[6];
    } // ArrayStringList

    /**
     * Constructs a {@code ArrayStringList} object with the values contained in other.
     *
     * @param other {@code StringList} object
     */
    public ArrayStringList(StringList other) {
        super();
        array = new String[6];
        add(other);
    } // ArrayStringList

    /** {@inheritDoc} */
    protected StringList build() {
        return new ArrayStringList();
    } // build

    /**
     * Extends the storage of {@code array} by a factor of 1.5
     * if the array length is less than or equal to its size.
     */
    private void enlarge() {
        if (array.length == 0) {
            String[] newArray = new String[6];
            array = newArray;
        } else {
            if (array.length <= size()) {
                // function used to expand array
                String[] newArray = new String[(int)(Math.round(array.length * 1.5))];
                for (int i = 0; i < array.length; i++) {
                    newArray[i] = array[i];
                } // for

                array = newArray;
            } // if
        } // if
    } // enlarge()

    /** {@inheritDoc} */
    public boolean add(String s) {
        if (s.equals("")) {
            throw new IllegalArgumentException("String must not be empty.");
        } // if
        if (s == null) {
            throw new NullPointerException();
        } // if

        enlarge();

        array[size()] = s;

        size++;
        return true;
    } // add

    /** {@inheritDoc} */
    public boolean add(StringList sl) {
        if (sl == null) {
            throw new NullPointerException();
        } // if
        if (sl.isEmpty()) {
            return false;
        } // if

        int slSize = sl.size();
        enlarge();

        for (int i = 0; i < slSize; i++) {
            enlarge();
            array[size()] = sl.get(i);
            size++;
        } // for

        return true;
    } // add

    /** {@inheritDoc} */
    public boolean add(int index, String s) {
        if (s.equals("")) {
            throw new IllegalArgumentException();
        } // if
        if (s == null) {
            throw new NullPointerException();
        } // if
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException();
        } // if

        String[] newArray = new String[size()];

        // values of array copied to newArray
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        } // for

        enlarge();

        // values of array are overwritten
        for (int i = 0; i < index; i++) {
            array[i] = newArray[i];
        } // for

        array[index] = s;

        // values after index are copied back to array
        if (!(index == size())) { // if specified index is not last index
            for (int i = index + 1; i < size() + 1; i++) {
                array[i] = newArray[i - 1];
            } // for
        } // if
        size++;
        return true;
    } // add

    /** {@inheritDoc} */
    public boolean add(int index, StringList sl) {
        if (sl == null) {
            throw new NullPointerException();
        } // if
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException();
        } // if
        if (sl.isEmpty()) {
            return false;
        } // if

        String[] newArray = new String[size()];

        // values of array copied to newArray
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        } // for

        int slSize = sl.size();

        // values up to index are copied back to array
        for (int i = 0; i < index; i++) {
            enlarge();
            array[i] = newArray[i];
        } // for

        // values of sl inserted into array
        for (int i = index; i < index + slSize; i++) {
            enlarge();
            array[i] = sl.get(i - index);
            size++;
        } // for

        // remaining values of original list added back to array
        for (int i = index + slSize; i < newArray.length + slSize; i++) {
            enlarge();
            array[i] = newArray[i - slSize];
        } // for

        return true;
    } // add

    /** {@inheritDoc} */
    public String get(int index) {
        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException();
        } // if
        return array[index];
    } // get

    /** {@inheritDoc} */
    public String remove(int index) {
        if ((index < 0) || index >= size()) {
            throw new IndexOutOfBoundsException();
        } // if

        String previous = get(index);
        String[] newArray = new String[size()];

        // values of list up to index added to newArray
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        } // for

        // values after the specified array added to newArray
        for (int i = index + 1; i < size(); i++) {
            newArray[i - 1] = array[i];
        } // for

        array = newArray;
        size--;
        return previous;
    } // remove

    /** {@inheritDoc} */
    public void clear() {
        array = new String[6];
        size = 0;
    } // clear

} // ArrayStringList
