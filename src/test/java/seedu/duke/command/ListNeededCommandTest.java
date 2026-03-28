package seedu.duke.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import seedu.duke.appstate.AppState;
import seedu.duke.module.ModuleList;
import seedu.duke.planner.PlannerList;

public class ListNeededCommandTest {
    @Test
    public void execute_returnsAllRequiredModules() {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);
        ListNeededCommand command = new ListNeededCommand();
        String result = command.execute(appState);
        assertTrue(result.contains("Modules required for graduation:"));
        assertTrue(result.contains("CS2113"));
        assertTrue(result.contains("MA1511"));
        assertTrue(result.contains("CG4002"));
        assertTrue(result.contains("CS1010"));
    }
}
