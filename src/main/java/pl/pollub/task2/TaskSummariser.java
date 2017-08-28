package pl.pollub.task2;

import lombok.Data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TaskSummariser {
    private static TaskSummariser instance = null;
    private List<Task> finishedTasks = new ArrayList<>();
    private List<Date> dates = new ArrayList<>();
    private final Connection databaseConnection = null;
    private final UserService userService = null;


    protected TaskSummariser(){
    }

    public static TaskSummariser getInstance() {
        if (instance == null) {
            synchronized (TaskSummariser.class) {
                if (instance == null) {
                    instance = new TaskSummariser();
                }
            }
        }
        return instance;
    }
    public void addFinishedTask(Task task){
        finishedTasks.add(task);
        dates.add(new Date());

        List<Integer> userIds = new ArrayList<>(task.getContributors());
        for(int id : userIds){
        for(int notify : userService.getUserById(id).getPreferredNotify()){
            NotifierFactory.createNotifier(notify).notify(userService.getUserById(id));
        }
    }

    AbstractCommsFactory commsFactory = AbstractCommsFactory.createFactory(new User(1));
        commsFactory.createNotifier().notify(task);

}
    public void printTaskAndDate(int index){
        System.out.println("Task "+finishedTasks.get(index)+"finished on "+dates.get(index));
    }
    public void printAllFinishedTasks(){
        for(int i=0 ; i<finishedTasks.size() ; i++){
            printTaskAndDate(i);
        }
    }
}