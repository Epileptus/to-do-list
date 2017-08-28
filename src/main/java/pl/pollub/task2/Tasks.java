package pl.pollub.task2;

import java.util.ArrayList;
import java.util.List;

public class Tasks {

    public Task createTaskWithId(int id){
        return new Task(id,0, new ArrayList<>());
    }
    public Task createTaskWithUserId(int id){
        return new Task(0,id,new ArrayList<>());
    }
    public Task createTaskWithContributors(List<Integer> contributors){
        return new Task(0,0,contributors);
    }
}
