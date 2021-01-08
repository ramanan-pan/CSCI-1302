package cs1302.generics;

/**
 * This class represents a ShippingContainer that can carry objects of any type.
 *
 * @param <ContentType> the type of the object in the container.
 */
public class ShippingContainer <ContentType> {

    /** The contents of the container. */
    private ContentType contents;
    /** The weight of the container in lbs. */
    private double weight;

    /**
     * Constructs a new {@code ShippingContainer} object
     * with the specified contents and weight.
     *
     * @param contents the contents of the container.
     * @param weight the weight of the container in lbs.
     */
    public ShippingContainer(ContentType contents, double weight) {
        setWeight(weight);
        setContents(contents);
    } // ShippingContainer

    /**
     * Modify the weight of this shipping container.
     *
     * @param weight the new weight of the container.
     */
    public void setWeight(double weight) {
        if (weight > 0.0) {
            this.weight = weight;
        } else {
            this.weight = 1.0;
        } // if
    } // setWeight

    /**
     * Modify the contents of this shipping container.
     *
     * @param contents the new contents of the container.
     */
    public void setContents(ContentType contents) {
        this.contents = contents;
    } // setContents

    /**
     * Returns the weight of this shipping container object.
     *
     * @return the weight of the container
     */
    public double getWeight() {
        return weight;
    } // getWeight

    /**
     * Returns the contents of this shipping container object.
     *
     * @return the contents of the container
     */
    public ContentType getContents() {
        return contents;
    } // getContents

} // ShippingContainer
