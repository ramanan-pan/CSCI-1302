package cs1302.ce10.assignment;

import cs1302.ce10.util.Course;
import java.util.Date;

/**
 * Represents Assignment object.
 */
public abstract class Assignment {

    /** Total point value for this homework. */
    private int points;
    /** Indicates if this is a bonus assignment. */
    private boolean bonus;
    /** Course where this homework is assigned. */
    private Course course;

    /**
     * Constructs a new {@code Assignment} object with the specified
     * arguments.
     *
     * @param points the total points allocated to this homework.
     * @param bonus indicates if this is a bonus homework.
     * @param course the course where this homework is assigned.
     *
     * @throws IllegalArgumentException if {@code points} is negative
     * or if {@code dueDate} or {@code course} is {@code null}.
     */
    public Assignment(int points, boolean bonus, Course course) {
        checkNull("Homework", course);

        if (points < 0) {
            throw new IllegalArgumentException("Homework Constructor: " +
                                               "Invalid homework point total");
        } // if
        this.bonus = bonus;
        this.points = points;
        this.course  = course;
    } // Homework

    /**
     * Updates the point total associated with this homework.
     *
     * @param points the new point total.
     * @throws IllegalArgumentException if {@code points}
     * is negative.
     */
    public void setPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Homework Constructor: " +
                                               "Invalid homework point total");
        } // if
        this.points = points;
    } // setPoints

    /**
     * Updates whether or not this homework is a bonus assignment.
     *
     * @param bonus the bonus indicator.
     */
    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    } // setBonus

    /**
     * Returns the boolean value of the bonus.
     *
     * @return bonus the state of bonus
     */
    public boolean isBonus() {
        return bonus;
    } // isBonus

    /**
     * Returns the number of points associated with this homework
     * assignment.
     *
     * @return the points associated with this {@code Homework} object.
     */
    public int getPoints() {
        return points;
    } // getPoints

    /**
     * Returns the course in which this homework is assigned.
     *
     * @return the {@link cs1302.ce10.Course} that assigned this
     * homework.
     */
    public Course getCourse() {
        return course;
    } // getCourse

    /**
     * Throws a {@code NullPointerException} if any values in the
     * varargs parameter, {@code o} are {@code null}. The
     * method performs no actions if all values in {@code o}
     * are non-null.
     *
     * @param method the name of the calling method.
     * @param o varargs parameter containing all objects to verify
     * @throws NullPointerException if any element of parameter
     * {@code o} is null.
     */
    private void checkNull(String method, Object ... o) {
        for (Object obj: o) {
            if (o == null) {
                throw new NullPointerException(method +
                                               ": Null Argument Provided");
            } // if
        } // for
    } // checkNull


} // Assignment
