package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.model.plan.Plan;

/**
 * A UI component that displays information of a {@code Person}.
 */
// TODO: Rename person to plan
public class PlanCard extends UiPart<Region> {

    private static final String FXML = "PlanListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Plan plan;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    /*
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;
    */

    /**
     * Creates a {@code PlanCard} with the given {@code Plan} and index to display.
     */
    public PlanCard(Plan plan, int displayedIndex) {
        super(FXML);
        this.plan = plan;
        name.setText(plan.getPlanName().toString());
        // phone.setText(person.getPhone().value);
        // address.setText(person.getAddress().value);
        // email.setText(person.getEmail().value);
        /*
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
         */
    }
}
