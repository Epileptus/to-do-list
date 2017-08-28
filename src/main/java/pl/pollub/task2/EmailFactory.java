package pl.pollub.task2;

import lombok.Data;

@Data
public class EmailFactory extends AbstractCommsFactory {
    private final User user;

    @Override
    public Notifier createNotifier() {
        return new EmailNotifier();
    }

    @Override
    public Reminder createReminder() {
        return new EmailReminder();
    }
}
