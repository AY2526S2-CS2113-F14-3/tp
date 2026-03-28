package seedu.duke.appstate;

import seedu.duke.module.ModuleList;
import seedu.duke.planner.PlannerList;
import seedu.duke.profile.UserProfile;

public class AppState {
    private final ModuleList module;
    private final PlannerList planner;
    private final UserProfile profile;

    public AppState(ModuleList module, PlannerList planner, UserProfile profile) {
        this.module = module;
        this.planner = planner;
        this.profile = profile;
    }

    public ModuleList getModule() {
        return module;
    }

    public PlannerList getPlanner() {
        return planner;
    }

    public UserProfile getProfile() {
        return profile;
    }
}
