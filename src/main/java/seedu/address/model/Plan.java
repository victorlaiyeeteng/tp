package seedu.address.model;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;

import seedu.address.model.person.Person;

/**
 * Represents a Plan in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Plan {
    /** A brief description of this plan. */
    private final String planName;
    /** The date and time of this plan. */
    private final LocalDateTime dateTime;
    /** The friend this plan involves. */
    private final Person friend;

    /**
     * Class constructor for Plan.
     * @param planName A brief description of the plan.
     * @param dateTime A LocalDateTIme object of this plan.
     * @param friend The friend this plan involves.
     */
    public Plan(String planName, LocalDateTime dateTime, Person friend) {
        requireAllNonNull(planName, dateTime, friend);
        this.planName = planName;
        this.dateTime = dateTime;
        this.friend = friend;
    }

    public String getPlanName() {
        return planName;
    }

    public LocalDateTime getPlanDateTime() {
        return dateTime;
    }

    public Person getPlanFriend() {
        return friend;
    }

    /**
     * Returns true if both plans have the same name, dateTime and friend fields.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Plan)) {
            return false;
        }

        Plan otherPlan = (Plan) other;
        return planName.equals(otherPlan.planName)
                && dateTime.equals(otherPlan.dateTime)
                && friend.equals(otherPlan.friend);
    }
    /**
     * Returns string of format [PLAN_NAME with FRIEND_NAME at DATE_TIME]
     */
    @Override
    public String toString() {
        String friendName = friend.getName().toString();
        String dateTimeString = dateTime.toString();
        dateTimeString.replace('T', ' ');
        return '[' + " with " + friendName + " at " + dateTimeString + ']';
    }
}
