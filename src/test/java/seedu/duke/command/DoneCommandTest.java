package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.module.ModuleList;
import seedu.duke.appstate.AppState;
import seedu.duke.planner.PlannerList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoneCommandTest {
    @Test
    public void execute_validModule_success() {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);
        DoneCommand command = new DoneCommand("CS1231", 4);

        String result = command.execute(appState);

        assertEquals("CS1231 has been added (4 MCs).", result);
        assertEquals(1, modules.getCompletedModules().size());
    }

    @Test
    public void execute_lowercaseInput_convertedToUppercase() {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);

        DoneCommand command = new DoneCommand("cs1231", 4);
        String result = command.execute(appState);

        assertEquals("CS1231 has been added (4 MCs).", result);
    }
}
