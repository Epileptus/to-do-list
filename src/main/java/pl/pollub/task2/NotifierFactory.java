package pl.pollub.task2;

public class NotifierFactory{
    public static Notifier createNotifier(int type){
        switch (type){
            case 0: //email
                return new EmailNotifier();
            case 1: //sms
                return new SMSNotifier();
            default:
                return new NullNotifier();
        }
    }
}
