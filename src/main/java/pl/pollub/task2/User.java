package pl.pollub.task2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    private final int id;
    private final String email;
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
}
