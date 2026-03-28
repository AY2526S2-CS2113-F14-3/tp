package seedu.duke.appstate;

import seedu.duke.module.ModuleList;
import seedu.duke.planner.PlannerList;

public class AppState {
    private final ModuleList module;
    private final PlannerList planner;

    public AppState(ModuleList module, PlannerList planner) {
        this.module = module;
        this.planner = planner;
    }

    public ModuleList getModule() {
        return module;
    }

    public PlannerList getPlanner() {
        return planner;
    }
}
