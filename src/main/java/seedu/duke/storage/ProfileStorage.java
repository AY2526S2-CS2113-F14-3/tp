package seedu.duke.storage;

import seedu.duke.profile.UserProfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileStorage {
    private static final Logger logger = Logger.getLogger(ProfileStorage.class.getName());
    private static final String PROFILE_FILE_PATH = "data/profile.txt";

    public UserProfile loadProfile() throws IOException {
        File file = new File(PROFILE_FILE_PATH);

        File parent = file.getParentFile();
        assert parent != null : "Parent directory should exist for profile path";
        parent.mkdirs();

        if (!file.exists()) {
            file.createNewFile();
            logger.info("Profile file not found. Created new file at " + PROFILE_FILE_PATH);
            return null;
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\|");
            if (parts.length != 2) {
                scanner.close();
                throw new IOException("Invalid profile format in " + PROFILE_FILE_PATH);
            }

            String name = parts[0].trim();
            double gpa = Double.parseDouble(parts[1].trim());

            scanner.close();
            logger.log(Level.INFO, "Loaded profile for user: {0}", name);
            return new UserProfile(name, gpa);
        }

        scanner.close();
        return null;
    }

    public void saveProfile(UserProfile profile) throws IOException {
        assert profile != null : "Profile should not be null";

        FileWriter writer = new FileWriter(PROFILE_FILE_PATH);
        writer.write(profile.getName() + "|" + profile.getGpa());
        writer.write("\n");
        writer.close();

        logger.log(Level.INFO, "Saved profile for user: {0}", profile.getName());
    }
}
