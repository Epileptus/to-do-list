package pl.pollub.task2;

import lombok.Data;

@Data
public class SMSFactory extends AbstractCommsFactory {
    private final User user;

    @Override
    public Notifier createNotifier() {
        return new SMSNotifier();
    }

    @Override
    public Reminder createReminder() {
        return new SMSReminder();
    }
}
