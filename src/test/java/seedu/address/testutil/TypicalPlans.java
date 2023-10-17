package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.plan.Plan;

/**
 * A utility class containing a list of {@code Plan} objects to be used in tests.
 */
public class TypicalPlans {

    public static final Plan MEETING = new PlanBuilder().withPlanName("Meeting")
            .withPlanDateTime("2025-10-23-12:00").withPlanFriend(ALICE).build();
    public static final Plan GAMING = new PlanBuilder().withPlanName("Gaming")
            .withPlanDateTime("2025-10-28-16:00").withPlanFriend(ALICE).build();
    public static final Plan EXERCISING = new PlanBuilder().withPlanName("Exercising")
            .withPlanDateTime("2025-11-01-09:00").withPlanFriend(ALICE).build();
    public static final Plan HACKATHON = new PlanBuilder().withPlanName("Hackathon")
            .withPlanDateTime("2025-09-01-06:00").withPlanFriend(ALICE).build();
    public static final Plan BALI = new PlanBuilder().withPlanName("Bali Trip")
            .withPlanDateTime("2025-06-01-09:00").withPlanFriend(ALICE).build();

    private TypicalPlans() {}

    /**
     * Returns an {@code AddressBook} with all the typical plans.
     */
    public static AddressBook getTypicalAddressBookWithPlans() {
        AddressBook ab = TypicalPersons.getTypicalAddressBook();
        for (Plan plan: getTypicalPlans()) {
            ab.addPlan(plan);
        }
        return ab;
    }

    public static List<Plan> getTypicalPlans() {
        return new ArrayList<>(Arrays.asList(MEETING, GAMING, EXERCISING, HACKATHON, BALI));
    }
}
