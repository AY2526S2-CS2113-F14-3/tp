package seedu.duke.command;

import seedu.duke.module.ModuleList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CountCommand extends Command {

    private static final Logger logger = Logger.getLogger(CountCommand.class.getName());

    @Override
    public String execute(ModuleList modules) {
        assert modules != null : "ModuleList should not be null";
        logger.log(Level.INFO, "Executing count command");
        String result = modules.countMcs();
        assert result != null : "countMcs result should not be null";
        return result;
    }

}
