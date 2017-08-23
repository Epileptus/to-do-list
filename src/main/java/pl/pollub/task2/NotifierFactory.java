package pl.pollub.task2;

public class NotifierFactory {
    public static Notifier createNotifier(int type){
        switch (type){
            case 0: //sms
                return new EmailNotifier();
            case 1: //email
                return new SMSNotifier();
            default:
                return new EmailNotifier();
        }
    }
}
