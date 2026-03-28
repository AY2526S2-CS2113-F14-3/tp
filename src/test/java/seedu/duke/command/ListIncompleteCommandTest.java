package seedu.duke.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import seedu.duke.appstate.AppState;
import seedu.duke.exception.DuplicateException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.planner.PlannerList;

public class ListIncompleteCommandTest {
    @Test
    public void execute_noCompletedModules_returnsAllIncompleteModules() {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);
        ListIncompleteCommand command = new ListIncompleteCommand();
        String result = command.execute(appState);
        assertTrue(result.contains("Incomplete modules:"));
        assertTrue(result.contains("CS2113"));
        assertTrue(result.contains("MA1511"));
        assertTrue(result.contains("CS1010"));
    }

    @Test
    public void execute_someCompletedModules_returnsRemainingIncompleteModules() throws DuplicateException {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);
        modules.addModule(new Module("CS2113",4));
        modules.addModule(new Module("CS1231",4));
        modules.addModule(new Module("CP3880",10));
        ListIncompleteCommand command = new ListIncompleteCommand();
        String result = command.execute(appState);
        assertTrue(result.contains("Incomplete modules:"));
        assertFalse(result.contains("CS2113"));
        assertFalse(result.contains("CS1231"));
        assertTrue(result.contains("MA1511"));
    }
}
