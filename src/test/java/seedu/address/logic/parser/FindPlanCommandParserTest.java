package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindPlanCommand;
import seedu.address.model.person.Name;

public class FindPlanCommandParserTest {

    private FindPlanCommandParser parser = new FindPlanCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPlanCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindPlanCommand() {
        FindPlanCommand expectedFindPlanCommand =
                new FindPlanCommand(new Name("Alice Pauline"));
        assertParseSuccess(parser, "Alice Pauline", expectedFindPlanCommand);
    }
}
