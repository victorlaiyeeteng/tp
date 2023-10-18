package seedu.address.testutil;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditPlanCommand.EditPlanDescriptor;
import seedu.address.model.plan.Plan;
import seedu.address.model.plan.PlanName;
import seedu.address.model.plan.PlanDateTime;
import seedu.address.model.person.Phone;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPlanDescriptorBuilder {

    private EditPlanDescriptor descriptor;

    public EditPlanDescriptorBuilder() {
        descriptor = new EditPlanDescriptor();
    }

    public EditPlanDescriptorBuilder(EditPlanDescriptor descriptor) {
        this.descriptor = new EditPlanDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPlanDescriptor} with fields containing {@code plans}'s details
     */
    public EditPlanDescriptorBuilder(Plan plan) {
        descriptor = new EditPlanDescriptor();
        descriptor.setPlanName((plan.getPlanName());
        descriptor.setPlanDateTime(plan.getPlanDateTime());
        descriptor.setPlanFriend(plan.getPlanFriend());
    }

    /**
     * Sets the {@code PlanName} of the {@code EditPlanDescriptor} that we are building.
     */
    public EditPlanDescriptorBuilder withPlanName(String planName) {
        descriptor.setPlanName(new PlanName(planName));
        return this;
    }

    /**
     * Sets the {@code dateTime} of the {@code EditPlanDescriptor} that we are building.
     */
    public EditPlanDescriptorBuilder withPlanDateTime(String dateTime) {
        descriptor.setPlanDateTime(new PlanDateTime(dateTime));
        return this;
    }

    /**
     * Sets the {@code Person} of the {@code EditPlanDescriptor} that we are building.
     */
    public EditPlanDescriptorBuilder withPlanFriend(String friend) {
        descriptor.setPlanFriend(new Person(friend));
        return this;
    }
    // to be corrected ^

    public EditPlanDescriptor build() {
        return descriptor;
    }
}
