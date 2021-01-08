package cs1302.ce12;

import cs1302.Utility;

/**
 * Represent a container for {@code Object} objects. {@code ObjectContainer}
 * objects cannot store {@code null} values.
 */
public class ObjectContainer {

    /** The contents of this container. */
    private Object contents;

    /**
     * Constructs a {@code cs1302.generics.ObjectContainer} object
     * with the specified {@code Object}. The specified value cannot
     * be {@code null}.
     *
     * @param contents the contents for the {@code ObjectContainer}.
     * @throws NullPointerException if the contents are null.
     */
    public ObjectContainer(Object contents) {
        set(contents);
    } // ObjectContainer

    /**
     * Modifies the contents of this {@code ObjectContainer} object.
     * The specified value cannot be {@code null}.
     *
     * @param contents the contents for the {@code ObjectContainer}.
     * @throws NullPointerException if the contents are null.
     */
    public void set(Object contents) {
        Utility.nullCheck("ObjectContainer: set", contents);
        this.contents = contents;
    } // set

    /**
     * Returns the contents of this {@code ObjectContainer} object.
     *
     * @return contents the contents for the {@code ObjectContainer}.
     */
    public Object get() {
        return contents;
    } // get

} // ObjectContainer
