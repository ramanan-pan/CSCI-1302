package cs1302.ce06.contract;

/**
 * Represents the interface for an object that is drivable.
 * Drivable objects can {@code speedUp} and {@code slowDown}.
 */
public interface Drivable {

    /**
     * Increases the speed of the object by the specified amount.
     * @param amount the specified amount in mph
     * @return true when the operation was successful; false otherwise
     */
    public boolean speedUp(double amount);

    /**
     * Decreases the speed of the object by the specified amount.
     * @param amount the specified amount in mph
     * @return true when the operation was successful; false otherwise
     */
    public boolean slowDown(double amount);

    /**
     * Stops the motion of the object, making the speed zero.
     * @param inMotion the state of the Drivable object
     * @return true when the operation was successful; false otherwise
     */
    public boolean stop(boolean inMotion);
} // Drivable
