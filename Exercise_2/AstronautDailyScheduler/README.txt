Exercise-2:

File Structure:
Exercise_2.AstronautDailyScheduler/
│
├─ classes/               # Core classes
│  ├─ Task.java           # Represents a single task (description, start/end time, priority, status)
│  ├─ ScheduleManager.java# Manages tasks using Singleton; handles add/remove/mark complete
│  ├─ TaskFactory.java    # Factory for creating validated Task objects with unique IDs
│  └─ ConflictNotifier.java # Implements Observer to alert on task conflicts/events
│
├─ enums/                 # Enum types
│  ├─ Priority.java       # HIGH, MEDIUM, LOW
│  ├─ Status.java         # PENDING, COMPLETED
│  ├─ MenuOption.java     # CLI menu options mapping
│  └─ TaskEventType.java  # ADDED, REMOVED, CONFLICT, COMPLETED, ERROR
│
├─ Exceptions/            # Custom exceptions
│  ├─ InvalidTimeFormatException.java
│  ├─ TaskConflictException.java
│  └─ TaskNotFoundException.java
│
├─ interfaces/            # Observer interface
│  └─ ScheduleObserver.java
│
├─ Main.java              # Console-based application entry point
└─ README.txt             # Project documentation


Astronaut Daily Scheduler:
-A console-based Java application that helps astronauts manage their daily schedules efficiently.
-Users can add, remove, view, and track tasks with priority, completion status, and alerts for conflicts and deadlines.

Features:
1)Mandatory Features:

-Add tasks with description, start/end time, and priority.
-Remove tasks by ID.
-View all tasks sorted by start time.
-Validate overlapping tasks and show conflict messages.
-Error messages for invalid operations.

2)Optional Features:

-Mark tasks as completed by ID.
-View tasks filtered by priority.
-Track removed tasks for history.
-View tasks that are upcoming (starting soon) and critical (ending soon) dynamically.
-Display a summary of total, completed, pending, and priority-based task counts.

3)Non-functional Features:

-Graceful exception handling.
-Dynamic input validation (invalid time, empty descriptions, invalid priority).
-Logging via observer notifications (e.g., conflicts, task added/removed).

Design Patterns Used:

1)Singleton Pattern:
-Implemented in ScheduleManager to ensure that there is only one central instance managing all tasks throughout the application.
-This prevents inconsistencies in task data and ensures all operations (add, remove, mark complete) go through a single, controlled access point.

2)Factory Pattern:
-Implemented via TaskFactory to handle creation of Task objects.
-The factory abstracts the complexity of object creation, validates input data (time format, priority), and automatically assigns unique IDs to tasks.
-This promotes clean code, reduces duplication, and centralizes task creation logic.

3)Observer Pattern:
-Implemented using the ScheduleObserver interface and the ConflictNotifier class.
-Observers are notified of important task events, such as conflicts, additions, removals, or completion updates.
-This decouples the task management logic from the notification logic, enabling flexible event handling and future extensions like GUI notifications or logging.

Code-Explanation and Purpose:

1)classes
-ConflictNotifier.java:
→ Implements Observer,listens for task events (conflicts, updates) and logs/prints them.

-LoggerUtil.java:
→ Centralized logging utility (INFO, ERROR) → separates cross-cutting concern.

-ScheduleManager.java:
→ Singleton,manages CRUD ops, task validation, conflict detection, observers, summaries.

-Task.java:
→ Entity class; represents a single task with ID, timings, priority, and status. Encapsulates conflict logic.

-TaskEvent.java:
→ Event object; holds event type, task, and message for observer notifications.

-TaskFactory.java:
→ Factory; validates and creates Task objects from raw input (strings → domain objects).

2)enums
-MenuOption.java:
→ Maps menu input to program actions (Command-like structure).

-Priority.java:
→ Defines priority levels with validation.

-Status.java:
→ Represents task lifecycle (PENDING/COMPLETED).

-TaskEventType.java:
→ Enumerates all possible task-related events for the Observer Pattern.

3)exceptions

-InvalidTimeFormatException.java:
→ Signals invalid time parsing errors.

-TaskConflictException.java:
→ Signals overlapping/conflicting task scheduling.

-TaskNotFoundException.java:
→ Signals attempts to remove/mark non-existent tasks.

4)interfaces

-ScheduleObserver.java:
→ Observer contract for receiving task events
→ supports decoupling between manager & notifier.

Main-class:

-Main.java:
→ Console UI + Controller,handles user input/output, delegates all business logic to ScheduleManager.

Design Principle Mapping:
1)Singleton → ScheduleManager (single shared scheduler).
2)Factory → TaskFactory (valid, uniform task creation).
3)Observer → ScheduleObserver + ConflictNotifier + TaskEvent (decoupled notifications).
4)Separation of Concerns → LoggerUtil (logging), Task (entity), Exceptions (error handling).

Expected-Output and Test Cases:

Positive Test Cases:

1)Add Task "Morning Exercise"
Input:
1
Enter description: Morning Exercise
Enter start time (HH:mm): 07:00
Enter end time (HH:mm): 08:00
Enter priority (HIGH, MEDIUM, LOW): HIGH

Output:
[ADDED] Task "Morning Exercise" added successfully.

2)Add Task "Team Meeting"
Input:
1
Enter description: Team Meeting
Enter start time (HH:mm): 09:00
Enter end time (HH:mm): 10:00
Enter priority (HIGH, MEDIUM, LOW): MEDIUM

Output:
[ADDED] Task "Team Meeting" added successfully.

3)View All Tasks:
Input:
3
Output:
[ID: 1] Morning Exercise (07:00 - 08:00) [HIGH] Status: PENDING
[ID: 2] Team Meeting (09:00 - 10:00) [MEDIUM] Status: PENDING

4)Remove Task (Morning Exercise, ID 1):
Input:
2
Enter Task ID to remove: 1
Output:
[REMOVED] Task with ID 1 removed successfully.

5)Add Task "Lunch Break":
Input:
1
Enter description: Lunch Break
Enter start time (HH:mm): 12:00
Enter end time (HH:mm): 13:00
Enter priority (HIGH, MEDIUM, LOW): LOW

Output:
[ADDED] Task "Lunch Break" added successfully.


Negative Test Cases:
1)Add Overlapping Task "Training Session":
Input:
1
Enter description: Training Session
Enter start time (HH:mm): 09:30
Enter end time (HH:mm): 10:30
Enter priority (HIGH, MEDIUM, LOW): HIGH

Output:
[CONFLICT] Task "Training Session" conflicts with existing task "Team Meeting"

2)Remove Non-Existent Task (ID 999):
Input:
2
Enter Task ID to remove: 999

Output:
Error: Task with ID 999 not found.

3)Add Task with Invalid Time:
Input:
1
Enter description: Invalid Time Task
Enter start time (HH:mm): 25:00
Enter end time (HH:mm): 26:00
Enter priority (HIGH, MEDIUM, LOW): LOW

Output:
Invalid start time. Invalid time format: 25:00. Expected HH:mm

4)Add Overlap Task with Team Meeting:
Input:
1
Enter description: Overlap Task
Enter start time (HH:mm): 08:30
Enter end time (HH:mm): 09:30
Enter priority (HIGH, MEDIUM, LOW): MEDIUM

Output:
[CONFLICT] Task "Overlap Task" conflicts with existing task "Team Meeting"
Error: Task "Overlap Task" conflicts with existing task "Team Meeting"

5)View All Tasks (when no tasks exist):
Input:
3

Output:
No tasks scheduled for the day.

New Feature Test Cases:
1)Mark Task Complete (Team Meeting, ID 2):
Input:
6
Enter Task ID to mark complete: 2

Output:
[COMPLETED] Task with ID 2 marked as completed.

2)View Summary:
Input:
7
Output:
Summary:
Total Tasks: 2
Completed: 1
Pending: 1
High: 0 | Medium: 1 | Low: 1
Removed so far: 1

3)View Removed Tasks:
Input:
8
Output:
[ID: 1] Morning Exercise (07:00 - 08:00) [HIGH] Status: PENDING

4)View Upcoming Tasks (within 120 mins, assume now=08:45):
Input:
9
Enter threshold in minutes for upcoming tasks: 120
Output:
Tasks starting within the next 120 minutes:
[ID: 2] Team Meeting (09:00 - 10:00) [MEDIUM] Status: PENDING

5)View Critical Tasks (within 180 mins, assume now=09:15):
Input:
10
Enter threshold in minutes for critical tasks: 180

Output:
Tasks ending within the next 180 minutes:
[ID: 2] Team Meeting (09:00 - 10:00) [MEDIUM] Status: PENDING


