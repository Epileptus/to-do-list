package pl.pollub.task2;

public abstract class AbstractCommsFactory {

    public abstract Notifier createNotifier();
    public abstract Reminder createReminder();

    public static AbstractCommsFactory createFactory(User user){
        if(user.getPreferredNotify().get(0)==1)
            return new SMSFactory(user);
        else if(user.getPreferredNotify().get(0)==0)
            return new EmailFactory(user);
        else
            return new NullFactory();
    }

}
