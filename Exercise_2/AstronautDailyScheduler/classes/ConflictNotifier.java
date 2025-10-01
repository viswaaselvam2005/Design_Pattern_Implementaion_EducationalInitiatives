package Exercise_2.AstronautDailyScheduler.classes;

import Exercise_2.AstronautDailyScheduler.interfaces.ScheduleObserver;

public class ConflictNotifier implements ScheduleObserver {
    @Override
    public void onTaskEvent(TaskEvent event) {
        String msg = String.format("[%s] %s",
                event.getType(),
                event.getMessage());
        System.out.println(msg);
        LoggerUtil.info(msg);
    }
}
