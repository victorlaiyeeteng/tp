package seedu.address.logic.commands;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.LogicManager;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

import java.util.logging.Logger;


public class ListPlanCommand extends Command {

    public static final String COMMAND_WORD = "list-plan";
    public static final String MESSAGE_SUCCESS = "Listed all plans";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
