package pl.pollub.task2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    private final int id;
    private String email;
    private String phoneNumber;
    private List<Integer> preferredNotify = new ArrayList<>();
    private boolean hasPaidForSMS;

    public void addPreferredNotify(int notify) {
        if (!preferredNotify.contains(notify)) {
            if (notify == 1) {
                if (hasPaidForSMS)
                    preferredNotify.add(notify);
                else
                    System.out.println("Nie opłacono usługi.");
            } else
                preferredNotify.add(notify);
        }
    }
    public void removePreferredNotify(int notify){
        preferredNotify.remove(new Integer(notify));
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hasPaidForSMS=" + hasPaidForSMS +
                '}';
    }

    @Data
    public static class Builder {
        private final User user;

        public Builder(int id){
            user = new User(id);
        }
        public User build() {
            return user;
        }
        public Builder withEmail(String email){
            user.setEmail(email);
            return this;
        }
        public Builder withPhoneNumber(String number){
            user.setPhoneNumber(number);
            return this;
        }
        public Builder withHasPaidForSms(boolean paid){
            user.setHasPaidForSMS(paid);
            return this;
        }

    }
    public static void main(String[] args){
        User user = new User(1);
        System.out.println(user);
        User user1 = new Builder(1)
                .withEmail("kuba@gmail.com")
                .withHasPaidForSms(true)
                .withPhoneNumber("2312")
                .build();

        System.out.println(user1);
    }
}
