package Exercise_2.AstronautDailyScheduler.interfaces;

import Exercise_2.AstronautDailyScheduler.classes.TaskEvent;

public interface ScheduleObserver {
    void onTaskEvent(TaskEvent event);
}
