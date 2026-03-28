package seedu.duke.command;

import org.junit.jupiter.api.Test;

import seedu.duke.appstate.AppState;
import seedu.duke.module.ModuleList;
import seedu.duke.planner.PlannerList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveCommandTest {
    @Test
    public void execute_existingModule_removedSuccessfully() {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);

        DoneCommand doneCommand = new DoneCommand("CS1231",4);
        doneCommand.execute(appState);

        RemoveCommand removeCommand = new RemoveCommand("CS1231");
        String result = removeCommand.execute(appState);

        assertEquals("CS1231 has been removed", result);
        assertEquals(0, modules.getCompletedModules().size());
    }

    @Test
    public void execute_moduleNotInList_returnsErrorMessage() {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);

        RemoveCommand command = new RemoveCommand("CS1231");
        String result = command.execute(appState);

        assertEquals("CS1231 is not in your module list", result);
    }

    @Test
    public void execute_lowercaseInput_convertedToUppercase() {
        ModuleList modules = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(modules, planner);
        DoneCommand doneCommand = new DoneCommand("CS1231", 4);
        doneCommand.execute(appState);

        RemoveCommand removeCommand = new RemoveCommand("cs1231");
        String result = removeCommand.execute(appState);

        assertEquals("CS1231 has been removed", result);
    }

}
