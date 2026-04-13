# Russell - Project Portfolio Page

## Project: PathLock

PathLock is a desktop CLI application designed to help Computer Engineering (CEG) students at NUS plan and track their multi-year academic journey. It enables students to record completed modules, monitor MC progress towards the 160-MC graduation requirement, and organise planned modules across semesters, all offline, with data stored in human-editable files.

Given below are my contributions to the project.

- **New Feature**: Added persistent storage for user profiles.
    - What it does: saves and loads a user’s profile data, such as name and GPA, from a per-user storage directory.
    - Justification: This feature allows PathLock to support returning users without requiring them to re-enter their information every time the application starts.
    - Highlights: Stores profile data under a user-specific folder structure. Handles first-time users, overwriting updated profile data, and loading profiles with decimal GPA values.

- **New Feature**: Added persistent storage for completed modules.
    - What it does: saves and loads the list of completed modules for each user.
    - Justification: This feature is necessary for PathLock to serve as a long-term planning tool, since users need their academic progress to persist across sessions.
    - Highlights: Ensures storage files and parent directories are created automatically. Supports loading from empty files and ignores blank lines in the storage file format.

- **New Feature**: Added persistent storage for planners, including support for multiple planner variations.
    - What it does: allows a user to save and load different planner versions under separate planner files.
    - Justification: Students often want to explore multiple academic plans before deciding on a final pathway. Supporting multiple planner files makes PathLock more flexible for long-term module planning.
    - Highlights: Added planner naming support, file path switching, and planner listing. Planner files are stored under a per-user `plans` directory and can be loaded independently.

- **Code contributed**: [reposense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2026-02-20T00%3A00%3A00&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=RNJH224&tabRepo=AY2526S2-CS2113-F14-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)


- **Enhancements to existing features**:
    - Refactored storage from a single shared file approach into a **per-user directory structure** under `data/users/<username>/...`, improving modularity and making the application more scalable for multiple users.
    - Improved planner storage to support planner name switching through methods such as setting a planner name and retrieving planner file paths.
    - Added support for listing existing planner files so users can manage multiple saved plans more easily.
    - Improved storage robustness by ensuring blank lines in saved files do not break the loading process.
    - Strengthened save-load round-trip correctness for profile, module, and planner storage through systematic testing.

- **Project management**:
    - Wrote and maintained JUnit tests for storage-related components, covering `ProfileStorage`, `ModStorage`, and `PlannerStorage`.
    - Helped verify correctness of storage logic through edge-case testing such as empty files, file creation, overwriting existing data, and ignoring malformed spacing/blank lines.
    - Supported the team’s implementation of user-specific data persistence, which underpins multiple core PathLock features.

- **Documentation**:
    - User Guide:
        - Documented storage-related behaviour so users understand that their profiles, completed modules, and planners are saved across sessions.
        - Contributed usage details for planner persistence and multi-plan support.  

    - Developer Guide:
        - Added documentation for storage design, including file locations, file formats, and save/load logic for profile, completed modules, and planners.
        - Created or refined UML/sequence diagrams for storage-related workflows such as saving and loading planner, profile, and completed module data.
        - Added testing instructions for storage-related components and manual testing considerations for persistence features.  


- **Testing**:
    - Added test coverage for profile storage, including:
        - loading when no file exists
        - saving valid profiles
        - overwriting an existing profile
        - preserving all fields after save-load round trips
    - Added test coverage for module storage, including:
        - loading from empty files
        - saving and loading multiple modules
        - auto-creation of files and parent directories
        - ignoring blank lines in storage files
    - Added test coverage for planner storage, including:
        - loading empty planners
        - saving and loading planner modules with semester data
        - changing planner file paths via planner names
        - listing planner files
        - ignoring blank lines in planner data files

- **Community**:
    - Helped improve the reliability of the project by identifying storage edge cases and turning them into automated tests.
    - Supported the overall architecture by making persistence cleaner and more extensible, especially for the move towards multiple planner variations.
    - Assisted in refining the team’s developer documentation for storage and testing workflows.