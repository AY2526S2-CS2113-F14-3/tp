package seedu.duke.command;

import seedu.duke.appstate.AppState;

public abstract class Command {
    public abstract String execute(AppState appState);
}
