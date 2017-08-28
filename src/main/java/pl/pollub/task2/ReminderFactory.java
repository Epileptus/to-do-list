package pl.pollub.task2;

public class ReminderFactory{
    public static Reminder createReminder(int type){
        switch (type){
            case 0: //email
                return new EmailReminder();
            case 1: //sms
                return new SMSReminder();
            default:
                return new NullReminder();
        }
    }
}
