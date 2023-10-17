package seedu.address.model.plan;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents the date and time of a Plan.
 * Guarantees: immutable; is valid as declared in {@link #isValidDateTime(String)}
 */
public class PlanDateTime {
    public static final String MESSAGE_CONSTRAINTS =
            "Date Time should be of the form YYYY-MM-DD-HH:MM";

    public static final String VALIDATION_REGEX = "[\\p{Digit}]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])-"
            + "(0[0-9]|1[0-9]|2[0-3]):[0-5][0:9]";

    public final LocalDateTime planDateTime;

    /**
     * Constructs a {@code PlanDateTime}.
     *
     * @param dateTimeString A valid date time string of the format YYYY-MM-DD-HH:MM.
     */
    public PlanDateTime(String dateTimeString) {
        requireNonNull(dateTimeString);
        checkArgument(isValidDateTime(dateTimeString), MESSAGE_CONSTRAINTS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        planDateTime = dateTime;
    }

    /**
     * Returns true if a given date time is valid.
     */
    public static boolean isValidDateTime(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String dateTimeString = planDateTime.toString();
        String formattedString = dateTimeString.replace('T', ' ');
        return formattedString;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PlanDateTime)) {
            return false;
        }

        PlanDateTime otherTime = (PlanDateTime) other;
        return this.planDateTime.equals(otherTime.planDateTime);
    }

    @Override
    public int hashCode() {
        return this.planDateTime.hashCode();
    }
}
