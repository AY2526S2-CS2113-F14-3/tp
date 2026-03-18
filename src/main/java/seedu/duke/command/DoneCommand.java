package seedu.duke.command;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.exception.DuplicateException;
import seedu.duke.storage.Storage;

import java.io.IOException;

public class DoneCommand extends Command {

    private final String moduleCode;

    public DoneCommand(String moduleCode) {
        this.moduleCode = moduleCode.toUpperCase();
    }

    @Override
    public String execute(ModuleList modules) {
        int modularCredits = ModuleList.getMcForModule(moduleCode);
        Module newModule = new Module(moduleCode, modularCredits);
        try {
            modules.addModule(newModule);
            Storage.save(modules.completedModules);
            return moduleCode + " has been added";
        } catch (DuplicateException | IllegalArgumentException e) {
            return e.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
