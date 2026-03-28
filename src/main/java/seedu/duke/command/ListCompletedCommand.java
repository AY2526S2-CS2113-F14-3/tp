package seedu.duke.command;

import seedu.duke.appstate.AppState;
import seedu.duke.module.ModuleList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ListCompletedCommand extends Command {
    private final Logger logger = Logger.getLogger(ListCompletedCommand.class.getName());

    @Override
    public String execute(AppState appState) {
        // Defensive check: modules should never be null when execute is called
        ModuleList modules = appState.getModule();
        assert modules != null : "ModuleList should not be null";

        // Logs that this command has started running
        logger.log(Level.FINE, "Executing ListCompletedCommand");

        String result = modules.listCompletedModules();

        // Logs that the command finished successfully
        logger.log(Level.FINE, "Completed modules listed successfully");

        return result;
    }

}
