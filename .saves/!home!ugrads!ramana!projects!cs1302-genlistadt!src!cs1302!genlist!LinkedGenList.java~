package cs1302.genlist;

import cs1302.genlistadt.GenList;
import cs1302.genlist.Node;
import java.util.function.Function;

/**
 * The {@code LinkedGenList<T>} class extends the {@code BaseGenList<T>} class
 * which implements the {@code GenList<T>} interface and represents a List ADT.
 */
public class LinkedGenList<T> extends BaseGenList<T> {

    /** The head or first node of the {@code LinkedGenList<T>}. */
    private Node<T> head;

    /**
     * Constructs a {@code LinkedGenList<T>} object with the size as 0
     * and sets the head node to null.
     */
    public LinkedGenList() {
        super();
        this.head = null;
    } // LinkedGenList

    /**
     * Constructs a {@code LinkedGenList<T>} object with the values contained in other.
     *
     * @param other {@code GenList<U>} object
     * @param <U> class type which is sub-class of {@code T}
     */
    public <U extends T> LinkedGenList(GenList<U> other) {
        super();
        this.head = null;
        add(other);
    } // LinkedGenList

    /** {@inheritDoc} */
    protected GenList<T> build() {
        return new LinkedGenList<T>();
    } // build

    /** {@inheritDoc} */
    public boolean add(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        } // if

        Node<T> temp = head; // used to iterate through nodes
        Node<T> newNode = new Node<T>(obj);

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
    public <U extends T> boolean add(GenList<U> list) {
        if (list == null) {
            throw new NullPointerException();
        } // if
        if (list.isEmpty()) {
            return false;
        } // if

        Node<T> temp = head;
        int glSize = list.size(); // holds size of gen list

        if (temp != null) {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            } // while
            for (int i = 0; i < glSize; i++) { // appends values of gen list this list
                temp.setNext(new Node<T>(list.get(i)));
                temp = temp.getNext();
                size++;
            } // for
        } else { // if list is empty
            head = new Node<T>(list.get(0));
            size++;
            temp = head;
            for (int i = 1; i < glSize; i++) {
                temp.setNext(new Node<T>(list.get(i)));
                temp = temp.getNext();
                size++;
            } // for
        } // if
        return true;
    } // add

    /** {@inheritDoc} */
    public boolean add(int index, T obj) {
        if (obj == null) {
            throw new NullPointerException();
        } // if
        if ((index < 0) || (index > this.size())) {
            throw new IndexOutOfBoundsException();
        } // if

        Node<T> temp = head;
        Node<T> newNode = new Node<T>(obj);

        if (index == 0) { // if add method is used to add obj at 0
            if (this.size() == 0) { // if list is empty
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
    public <U extends T> boolean add(int index, GenList<U> list) {
        if (list == null) {
            throw new NullPointerException();
        } // if
        if ((index < 0) || (index > this.size())) {
            throw new IndexOutOfBoundsException();
        } // if
        if (list.isEmpty()) {
            return false;
        } // if

        Node<T> temp = head;
        Node<T> glEnd; // holds reference to end of gen list
        Node<T> glBegin; // holds reference to first node of gen list
        int glSize = list.size();

        if (index == 0) {
            if (this.size() == 0) { // if list is empty
                head = new Node<T>(list.get(0));
                size++;
                temp = head;
                for (int i = 1; i < glSize; i++) {
                    temp.setNext(new Node<T>(list.get(i)));
                    temp = temp.getNext();
                    size++;
                } // for
            } else { // if index is 0
                glEnd = new Node<T>(list.get(0));
                glBegin = glEnd;
                size++;
                for (int i = 1; i < glSize; i++) {
                    glEnd.setNext(new Node<T>(list.get(i)));
                    glEnd = glEnd.getNext();
                    size++;
                } // for
                glEnd.setNext(temp);
                head = glBegin;
            } // if
        } else { // for any index besides 0
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            } // for
            glEnd = new Node<T>(list.get(0));
            glBegin = glEnd;
            size++;
            for (int i = 1; i < glSize; i++) {
                glEnd.setNext(new Node<T>(list.get(i)));
                glEnd = glEnd.getNext();
                size++;
            } // for
            if (temp.getNext() != null) { // if index is not last index
                glEnd.setNext(temp.getNext());
            } // if
            temp.setNext(glBegin);
        } // if
        return true;
    } // add

    /** {@inheritDoc} */
    public T get(int index) {
        Node<T> temp = head;

        if ((index < 0) || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        } // if

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        } // for

        return temp.getContents();
    } // get

    /** {@inheritDoc} */
    public T remove(int index) {
        if ((index < 0) || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        } // if

        T previous = this.get(index);

        Node<T> temp = head;
        if (index == 0) {
            head = temp.getNext();
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

    /** {@inheritDoc} */
    public <R> GenList<R> map(Function<T,R> f) {
        if (f == null) {
            throw new NullPointerException();
        } // if
        GenList<R> gl = new LinkedGenList<R>();
        for (T e : this) {
            if (f.apply(e) == null) {
                throw new NullPointerException();
            } // if
            gl.add(f.apply(e));
        } // for

        return gl;
    } // map


} // LinkedGenList
