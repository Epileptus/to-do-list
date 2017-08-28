package pl.pollub.task2;

public class NullFactory extends AbstractCommsFactory {
    @Override
    public Notifier createNotifier() {
        return new NullNotifier();
    }

    @Override
    public Reminder createReminder() {
        return new NullReminder();
    }
}
