package seedu.address.model.plan;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class PlanDateTimeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PlanDateTime(null));
    }

    @Test
    public void constructor_invalidDateTime_throwsIllegalArgumentException() {
        String invalidDateTime = "";
        assertThrows(IllegalArgumentException.class, () -> new PlanDateTime(invalidDateTime));
    }

    @Test
    public void isValidDateTime() {
        // null date time
        assertThrows(NullPointerException.class, () -> PlanDateTime.isValidDateTime(null));

        // invalid date time
        assertFalse(PlanDateTime.isValidDateTime("")); // empty string
        assertFalse(PlanDateTime.isValidDateTime(" ")); // spaces only
        assertFalse(PlanDateTime.isValidDateTime("cooldatetime")); // non-numeric
        assertFalse(PlanDateTime.isValidDateTime("1809-07-22-09:00")); // year in the past
        assertFalse(PlanDateTime.isValidDateTime("2222-07-22-09:00")); // year too far in the future
        assertFalse(PlanDateTime.isValidDateTime("2023-13-22-09:00")); // invalid month
        assertFalse(PlanDateTime.isValidDateTime("2023-12-32-09:00")); // invalid day
        assertFalse(PlanDateTime.isValidDateTime("2023-12-32-24:00")); // invalid hour
        assertFalse(PlanDateTime.isValidDateTime("2023-12-32-09:66")); // invalid minute

        // valid phone numbers
        assertTrue(PlanDateTime.isValidDateTime("2023-12-20-09:00"));
    }

    @Test
    public void equals() {
        PlanDateTime testDateTime = new PlanDateTime("2023-12-20-09:00");

        // same values -> returns true
        assertTrue(testDateTime.equals(new PlanDateTime("2023-12-20-09:00")));

        // same object -> returns true
        assertTrue(testDateTime.equals(testDateTime));

        // null -> returns false
        assertFalse(testDateTime.equals(null));

        // different types -> returns false
        assertFalse(testDateTime.equals(5.0f));

        // different values -> returns false
        assertFalse(testDateTime.equals(new PlanDateTime("2023-12-20-10:00")));
    }
}
