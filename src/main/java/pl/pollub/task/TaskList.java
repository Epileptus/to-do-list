package pl.pollub.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

@Component
public class TaskList {

    private final List<Task> tasks = new ArrayList<>();

    private final AtomicInteger counter = new AtomicInteger();

    public void add(Task newTask){
        newTask.setId(generateId());
        tasks.add(newTask);
    }
    public void remove(int index){
        tasks.remove(index);
    }
    public void remove(Task task){
        tasks.remove(task);
    }

    private int generateId() {
        return counter.incrementAndGet();
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}
