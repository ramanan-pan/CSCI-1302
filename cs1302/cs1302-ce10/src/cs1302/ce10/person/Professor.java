package cs1302.ce10.person;

/**
 * Represents a professor. Each professor has an associated ID, name, and tenure-track status.
 */
public class Professor extends Person {

    private boolean tenureTrack;

    /**
     * Constructs a {@code Professor} object.
     *
     * @param id the specified ID.
     * @param name the specified name
     * @param tenureTrack whether or not this {@code Professor}
     *        is tenure track.
     * @throws IllegalArgumentException if {@code id} is out of bounds
     *         {@code (id < 0 || id > 999_999_999)}.
     * @throws NullPointerException if {@code name} is {@code null}.
     * @throws IllegalArgumentException if {@code name} is empty.
     */
    public Professor(int id,
                     String name,
                     boolean tenureTrack) {
        super(id, name);
        setTenureTrack(tenureTrack);
    } // Professor

    /**
     * Returns the tenure-track status.
     *
     * @return the tenure-track status
     */
    public boolean isTenureTrack() {
        return tenureTrack;
    } // isTenureTrack

    /**
     * Sets the tenure-track status.
     *
     * @param tenureTrack the specified tenure-track status
     */
    public void setTenureTrack(boolean tenureTrack) {
        this.tenureTrack = tenureTrack;
    } // setTenureTrack

    /**
     * Returns the name.
     *
     * @param name the name.
     */
    private void checkName(String name) {
        if (getName() == null) {
            throw new NullPointerException("name cannot be null");
        } else if (getName().isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty string");
        } // if
    } // checkName

    /**
     * Checks the specified {@code id} to ensure it's not out of bounds.
     *
     * @param id the specified ID.
     * @throws IllegalArgumentException if {@code id} is out of bounds
     *         {@code (id < 0 || id > 999_999_999)}.
     */
    private void checkId(int id) {
        if (getId() < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        } else if (getId() > 999_999_999) {
            throw new IllegalArgumentException("id cannot exceed nine digits");
        } // if
    } // checkId

} // Professor
