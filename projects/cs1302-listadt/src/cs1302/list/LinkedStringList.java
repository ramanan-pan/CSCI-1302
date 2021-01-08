package cs1302.list;

import cs1302.listadt.StringList;

/**
 * The {@code LinkedStringList} class extends the {@code AbstractStringList} class
 * which implements the {@code StringList} interface and represents a List ADT.
 */
public class LinkedStringList extends AbstractStringList {

    /** The head or first node of the {@code LinkedStringList}. */
    private StringList.Node head;

    /**
     * Constructs a {@code LinkedStringList} object with the size as 0
     * and sets the head node to null.
     */
    public LinkedStringList() {
        super();
        this.head = null;
    } // LinkedStringList

    /**
     * Constructs a {@code LinkedStringList} object with the values contained in other.
     *
     * @param other {@code StringList} object
     */
    public LinkedStringList(StringList other) {
        super();
        this.head = null;
        add(other);
    } // LinkedStringList

    /** {@inheritDoc} */
    protected StringList build() {
        return new LinkedStringList();
    } // build

    /** {@inheritDoc} */
    public boolean add(String s) {
        if (s.equals("")) {
            throw new IllegalArgumentException();
        } // if
        if (s == null) {
            throw new NullPointerException();
        } // if

        StringList.Node temp = head; // used to iterate through nodes
        StringList.Node newNode = new StringList.Node(s);

        if (temp != null) { // if there are nodes already in the list
            while (temp.getNext() != null) {
                temp = temp.getNext();
            } // while
            temp.setNext(newNode);
            size++;
        } else { // if the list is empty
            head = newNode;
            size++;
        } // if
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

        StringList.Node temp = head;
        int slSize = sl.size(); // holds size of sl

        if (temp != null) {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            } // while
            for (int i = 0; i < slSize; i++) { // appends values of sl this list
                temp.setNext(new StringList.Node(sl.get(i)));
                temp = temp.getNext();
                size++;
            } // for
        } else { // if list is empty
            head = new StringList.Node(sl.get(0));
            size++;
            temp = head;
            for (int i = 1; i < slSize; i++) {
                temp.setNext(new StringList.Node(sl.get(i)));
                temp = temp.getNext();
                size++;
            } // for
        } // if
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

        StringList.Node temp = head;
        StringList.Node newNode = new StringList.Node(s);

        if (index == 0) { // if add method is used to add string at 0
            if (size() == 0) { // if list is empty
                head = newNode;
                size++;
            } else {
                newNode.setNext(temp);
                head = newNode;
                size++;
            } // if
        } else { // for any index except for 0
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            } // for
            if (temp.getNext() != null) { // if index is not last index in list
                newNode.setNext(temp.getNext());
            } // if
            temp.setNext(newNode);
            size++;
        } // if
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

        StringList.Node temp = head;
        StringList.Node slEnd; // holds reference to end of sl list
        StringList.Node slBegin; // holds reference to first node of sl list
        int slSize = sl.size();

        if (index == 0) {
            if (size() == 0) { // if list is empty
                head = new StringList.Node(sl.get(0));
                size++;
                temp = head;
                for (int i = 1; i < slSize; i++) {
                    temp.setNext(new StringList.Node(sl.get(i)));
                    temp = temp.getNext();
                    size++;
                } // for
            } else { // if index is 0
                slEnd = new StringList.Node(sl.get(0));
                slBegin = slEnd;
                size++;
                for (int i = 1; i < slSize; i++) {
                    slEnd.setNext(new StringList.Node(sl.get(i)));
                    slEnd = slEnd.getNext();
                    size++;
                } // for
                slEnd.setNext(temp);
                head = slBegin;
            } // if
        } else { // for any index besides 0
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            } // for
            slEnd = new StringList.Node(sl.get(0));
            slBegin = slEnd;
            size++;
            for (int i = 1; i < slSize; i++) {
                slEnd.setNext(new StringList.Node(sl.get(i)));
                slEnd = slEnd.getNext();
                size++;
            } // for
            if (temp.getNext() != null) { // if index is not last index
                slEnd.setNext(temp.getNext());
            } // if
            temp.setNext(slBegin);
        } // if
        return true;
    } // add

    /** {@inheritDoc} */
    public String get(int index) {
        StringList.Node temp = head;

        if ((index < 0) || index >= size()) {
            throw new IndexOutOfBoundsException();
        } // if

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        } // for

        return temp.getStr();
    } // get

    /** {@inheritDoc} */
    public String remove(int index) {
        if ((index < 0) || index >= size()) {
            throw new IndexOutOfBoundsException();
        } // if

        String previous = get(index);

        StringList.Node temp = head;
        if (index == 0) {
            head =  temp.getNext();
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            } // for
            if (temp.getNext() != null) { // if there is node after removed node
                temp.setNext(temp.getNext().getNext());
            } // if
        } // if
        size--;
        return previous;
    } // remove

    /** {@inheritDoc} */
    public void clear() {
        head = null;
        size = 0;
    } // clear

} // LinkedStringList
