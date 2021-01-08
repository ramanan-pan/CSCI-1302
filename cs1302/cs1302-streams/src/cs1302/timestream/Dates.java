package cs1302.timestream;

import java.time.LocalDate;
import java.time.Year;
import java.util.Random;

/**
 * Utility class for {@code java.time.LocalDate}
 * generation.
 */
public class Dates {

    /** Random Number Generator. */
    private static final Random RNG = new Random();

    /** 1970-01-01T00:00, the beginning of time. */
    public static final LocalDate EPOCH = LocalDate.ofEpochDay(0);

    /**
     * Returns a randomly generated {@code LocalDate}
     * within 100 years of the {@code EPOCH}.
     * @return a randomly generated {@code LocalDate}
     */
    public static LocalDate random() {
        long maxDays = EPOCH.lengthOfYear() * 100L;
        long rngDays = RNG.nextLong() % maxDays;
        return EPOCH.plusDays(rngDays);
    } // random

} // Dates
