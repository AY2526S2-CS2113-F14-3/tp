package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.DuplicateException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.appstate.AppState;
import seedu.duke.planner.PlannerList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountCommandTest {

    @Test
    public void execute_emptyModuleList_showsZeroMcs() {
        ModuleList ml = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(ml, planner);
        CountCommand cmd = new CountCommand();
        String result = cmd.execute(appState);
        assertTrue(result.contains("Completed: 0 / 160 MCs"));
        assertTrue(result.contains("0.0%"));
    }

    @Test
    public void execute_oneModule_showsCorrectMcs() throws DuplicateException {
        ModuleList ml = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(ml, planner);
        ml.addModule(new Module("CS2113", 4));
        CountCommand cmd = new CountCommand();
        String result = cmd.execute(appState);
        assertTrue(result.contains("Completed: 4 / 160 MCs"));
    }

    @Test
    public void execute_multipleModules_showsCumulativeMcs() throws DuplicateException {
        ModuleList ml = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(ml, planner);
        ml.addModule(new Module("MA1511", 2));
        ml.addModule(new Module("MA1512", 2));
        ml.addModule(new Module("CS2113", 4));
        CountCommand cmd = new CountCommand();
        String result = cmd.execute(appState);
        assertTrue(result.contains("Completed: 8 / 160 MCs"));
        assertTrue(result.contains("5.0%"));
    }

    @Test
    public void execute_externalModule_countsTowardsTotalMcs() {
        ModuleList ml = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(ml, planner);
        DoneCommand doneCommand = new DoneCommand("SEP1001", 4);
        doneCommand.execute(appState);
        CountCommand cmd = new CountCommand();
        String result = cmd.execute(appState);
        assertTrue(result.contains("Completed: 4 / 160 MCs"));
    }

    @Test
    public void execute_moreThan160Mcs_capsRemainingAtZero() {
        ModuleList ml = new ModuleList();
        PlannerList planner = new PlannerList();
        AppState appState = new AppState(ml, planner);

        for (int i = 1; i <= 41; i++) {
            String code = String.format("EX%04d", i); // EX0001, EX0002, ...
            DoneCommand doneCommand = new DoneCommand(code, 4);
            doneCommand.execute(appState);
        }

        CountCommand cmd = new CountCommand();
        String result = cmd.execute(appState);
        assertTrue(result.contains("Completed: 164 / 160 MCs"));
        assertTrue(result.contains("Incomplete: 0 MCs"));
    }
}
