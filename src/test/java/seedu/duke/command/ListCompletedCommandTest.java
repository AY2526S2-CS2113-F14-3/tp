package seedu.duke.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import seedu.duke.appState.AppState;
import seedu.duke.exception.DuplicateException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.planner.PlannerList;

public class ListCompletedCommandTest {
    @Test
    public void execute_noCompletedModules_returnsEmptyMessage() {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);
        ListCompletedCommand command = new ListCompletedCommand();
        String result = command.execute(appState);
        assertEquals("No modules completed yet.", result);
    }

    @Test
    public void execute_withCompletedModules_returnsCompletedList() throws DuplicateException {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);
        modules.addModule(new Module("CS2113",4));
        modules.addModule(new Module("CS1231",4));
        ListCompletedCommand command = new ListCompletedCommand();
        String result = command.execute(appState);
        assertTrue(result.contains("CS2113"));
        assertTrue(result.contains("CS1231"));
    }
}
